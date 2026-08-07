# ishumei-java-sdk

[English](./README.md) | [简体中文](./README.zh-CN.md)

[![Java](https://img.shields.io/badge/Java-8-orange)](https://github.com/easy-4-java/ishumei-java-sdk) [![License](https://img.shields.io/badge/license-Apache%202.0-green)](https://www.apache.org/licenses/LICENSE-2.0.txt)

ishumei-java-sdk provides a typed Java model layer for the Shumei (数美) anti-fraud and content-moderation API

> **Status**: early development on the `feature/1.0.x` line. Artifacts are not yet published to Maven Central; they are distributed through the project's private repository and GitHub Releases.

## Table of Contents

- [1. Project Overview](#1-project-overview)
- [2. Features & Status](#2-features--status)
- [3. Requirements & Compatibility](#3-requirements--compatibility)
- [4. Architecture & Modules](#4-architecture--modules)
- [5. Installation](#5-installation)
- [6. Quick Start](#6-quick-start)
- [7. Configuration](#7-configuration)
- [8. Core Usage / API](#8-core-usage--api)
- [9. Testing & Build](#9-testing--build)
- [10. Versioning & Branches](#10-versioning--branches)
- [11. Contributing & License](#11-contributing--license)

## 1. Project Overview

`ishumei-java-sdk` provides a typed Java model layer for the [Shumei (数美)](https://www.ishumei.com) anti-fraud and content-moderation API. It models the text, image and video moderation request/response payloads as plain JavaBeans (Lombok `@Data`, Jackson annotations), so applications can build request bodies and parse risk results without hand-writing JSON.

What it is:

- A DTO/model layer mirroring the Shumei risk-control API contract (`appId`, `accessKey`, `type`, `data`, risk `code`/`score`/`riskLevel`, hit `detail`, ...).
- Jackson-friendly: every model is annotated with `@JsonProperty` and `@JsonInclude(NON_NULL)`.

What it is not:

- It is not an HTTP client. The `feature/1.0.x` branch ships the model layer only; the transport layer (OkHttp) is a declared dependency of the project but is not yet implemented in this branch.

Typical scenarios:

| Scenario | How this SDK helps |
| :--- | :--- |
| Text moderation | Build `AntiFraudTextRequest`, serialize to JSON, post to the Shumei API, parse `AntiFraudResponse`. |
| Image moderation | Build `AntiFraudImageRequest` (single image or batch `imgs`), parse `AntiFraudImageResponse` / `BatchAntiFraudImageResponse`. |
| Video moderation | Build `AntiFraudVideoRequest` (`imgType`, `audioType`, `subtitleType`), parse `AntiFraudVideoResponse`. |
| Risk decision logic | `AntiFraudResponse.isSuccess()` / `isPass()` / `isReview()` / `isReject()` encode the Shumei result semantics. |

## 2. Features & Status

| Capability | Status | Notes |
| :--- | :--- | :--- |
| Text anti-fraud request model | Implemented | `AntiFraudTextRequest` + `AntiFraudTextRequestData` |
| Image anti-fraud request model | Implemented | `AntiFraudImageRequest` + `AntiFraudImageRequestData` (single `img` / batch `imgs`) |
| Video anti-fraud request model | Implemented | `AntiFraudVideoRequest` + `AntiFraudVideoRequestData` |
| Response models with risk semantics | Implemented | `AntiFraudResponse`, `AntiFraudImageResponse`, `BatchAntiFraudImageResponse`, `AntiFraudVideoResponse` |
| Risk detail / hit models | Implemented | `AntiFraudDetail`, `AntiFraudImageDetail`, `AntiFraudImageDetailHits`, `BatchAntiFraudImageItem` |
| HTTP transport client | Not yet implemented | OkHttp 4.9.3 is declared in the pom; no client class exists in this branch yet |
| Unit tests | Not yet present | JaCoCo 90% line-coverage gate is configured in the pom (non-failing) |

## 3. Requirements & Compatibility

| Item | Requirement |
| :--- | :--- |
| JDK | 8+ |
| Maven | 3.0+ (Maven Wrapper `mvnw` is included) |
| Dependencies | okhttp 4.9.3, jackson-databind 2.17.2, slf4j-api 2.0.18, lombok (provided) |

Version lines:

| Branch | JDK | Version pattern |
| :--- | :---: | :--- |
| `feature/1.0.x` | 8 | `1.0.x.*` |
| `feature/2.0.x` | 17 | `2.0.x.*` |
| `feature/3.0.x` | 21 | `3.0.x.*` |

## 4. Architecture & Modules

```text
+----------------+     +------------------------------+     +------------------+
| Application    | --> | com.ishumei.spring.boot.model | --> | JSON request     |
| code           |     | AntiFraud{Text,Image,Video}  |     | body (Jackson)   |
+----------------+     | Request (+ *RequestData)     |     +------------------+
                       +------------------------------+            |
                                                                   v
+----------------+     +------------------------------+     +------------------+
| Risk decision  | <-- | AntiFraud{...}Response DTO   | <-- | Shumei API       |
| isSuccess /    |     | code / score / riskLevel /   |     | (HTTP, JSON)     |
| isPass/Review/ |     | detail + hit models          |     |                  |
| isReject       |     +------------------------------+     +------------------+
+----------------+
```

Single-module jar. All 20 classes live in the `com.ishumei.spring.boot.model` package (the vendor namespace is kept as-is for API compatibility):

| Package | Contents |
| :--- | :--- |
| `com.ishumei.spring.boot.model` | Base request (`AntiFraudRequest`, `AntiFraudRequestData`), text/image/video requests and their `*RequestData`, responses (`AntiFraudResponse`, `AntiFraudImageResponse`, `BatchAntiFraudImageResponse`, `AntiFraudVideoResponse`), detail/hit models (`AntiFraudDetail`, `AntiFraudImageDetail`, `AntiFraudImageDetailHits`, `BatchAntiFraudImageItem`, `AntiFraudTextWordPostitionsDetail`) |

## 5. Installation

Add the dependency to your Maven project:

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>ishumei-java-sdk</artifactId>
    <version>1.0.x.20260630-SNAPSHOT</version>
</dependency>
```

Gradle:

```groovy
implementation 'io.github.easy4j:ishumei-java-sdk:1.0.x.20260630-SNAPSHOT'
```

The snapshot is served from the project's private repository; make sure the repository is configured in your build (see the `distributionManagement` section of the pom). No Maven Central release is available yet.

## 6. Quick Start

Build a text-moderation request and serialize it to JSON:

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ishumei.spring.boot.model.AntiFraudTextRequest;
import com.ishumei.spring.boot.model.AntiFraudTextRequestData;

AntiFraudTextRequest request = new AntiFraudTextRequest();
request.setAccessKey("your-access-key");   // provided by Shumei when the account is opened
request.setType("SOCIAL");                 // ZHIBO / ECOM / GAME / NEWS / FORUM / SOCIAL

AntiFraudTextRequestData data = new AntiFraudTextRequestData();
data.setText("hello world");
data.setNickname("tester");
request.setData(data);

String json = new ObjectMapper().writeValueAsString(request);
```

Expected output (field order follows the model declaration):

```json
{"appId":"default","accessKey":"your-access-key","type":"SOCIAL",
 "data":{"text":"hello world","gender":0,"nickname":"tester","isTokenSeperate":0}}
```

`appId` defaults to `"default"`, `gender` and `isTokenSeperate` default to `0`, and `null` fields are omitted (`@JsonInclude(NON_NULL)`).

## 7. Configuration

The models carry no runtime configuration. Connection-level concerns (timeouts, proxy, retries) belong to the not-yet-implemented transport client, so there are no configuration properties to set in this branch.

## 8. Core Usage / API

Interpreting a Shumei risk response:

```java
import com.ishumei.spring.boot.model.AntiFraudResponse;

AntiFraudResponse response = new ObjectMapper().readValue(apiBody, AntiFraudResponse.class);

boolean success = response.isSuccess();  // status == 0 && code == "1100"
boolean pass    = response.isPass();     // success && riskLevel == "PASS"
boolean review  = response.isReview();   // success && riskLevel == "REVIEW"
boolean reject  = response.isReject();   // success && riskLevel == "REJECT"

int    score    = response.getScore();       // risk score in [0, 1000], higher = riskier
String riskType = response.getRiskLevel();   // PASS / REVIEW / REJECT
```

Batch image check uses the batch request items:

```java
import com.ishumei.spring.boot.model.AntiFraudImageRequest;
import com.ishumei.spring.boot.model.AntiFraudImageRequestItem;

AntiFraudImageRequest request = new AntiFraudImageRequest();
request.setAccessKey("your-access-key");
request.setType("GAME");
request.getData().getImgs().add(new AntiFraudImageRequestItem()); // img / tokenId / btId per item
```

## 9. Testing & Build

```bash
./mvnw clean verify
```

The build is configured with:

- JaCoCo coverage reporting plus a line-coverage check rule with a 90% minimum target (`haltOnFailure=false`, so the check reports rather than blocks).
- Source and Javadoc jars attached at package time.
- A `central` release profile (GPG signing + Central publishing) reserved for official releases.

Note: this branch currently contains no test sources, so the coverage gate has nothing to measure yet.

## 10. Versioning & Branches

The project maintains three parallel version lines, each bound to a JDK baseline:

| Branch | JDK | Version pattern | Maintenance |
| :--- | :---: | :--- | :--- |
| `feature/1.0.x` | 8 | `1.0.x.*` | Current development line |
| `feature/2.0.x` | 17 | `2.0.x.*` | Maintained in parallel |
| `feature/3.0.x` | 21 | `3.0.x.*` | Maintained in parallel |

Snapshots are versioned `1.0.x.20260630-SNAPSHOT` on this branch. Releases are cut via GitHub Releases; Maven Central publication is planned but has not happened yet.

## 11. Contributing & License

Contributions are welcome — open an issue or pull request on GitHub. All source files are licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
