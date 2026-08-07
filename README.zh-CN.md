# ishumei-java-sdk

[English](./README.md) | [简体中文](./README.zh-CN.md)

[![Java](https://img.shields.io/badge/Java-17-orange)](https://github.com/easy-4-java/ishumei-java-sdk) [![License](https://img.shields.io/badge/license-Apache%202.0-green)](https://www.apache.org/licenses/LICENSE-2.0.txt)

ishumei-java-sdk 为数美（Shumei）反欺诈与内容审核 API 提供类型化的 Java 模型层。

> **项目状态**：`feature/2.0.x` 版本线早期开发中。制品尚未发布到 Maven Central，通过项目私服与 GitHub Releases 分发。

## 目录

- [1. 项目概述](#1-项目概述)
- [2. 功能与状态](#2-功能与状态)
- [3. 环境要求与兼容性](#3-环境要求与兼容性)
- [4. 架构与模块](#4-架构与模块)
- [5. 安装](#5-安装)
- [6. 快速开始](#6-快速开始)
- [7. 配置](#7-配置)
- [8. 核心用法 / API](#8-核心用法--api)
- [9. 测试与构建](#9-测试与构建)
- [10. 版本与分支](#10-版本与分支)
- [11. 贡献与许可](#11-贡献与许可)

## 1. 项目概述

`ishumei-java-sdk` 为数美（[Shumei](https://www.ishumei.com)）反欺诈与内容审核 API 提供类型化的 Java 模型层。它将文本、图片、视频审核的请求与响应载荷建模为普通 JavaBean（Lombok `@Data` + Jackson 注解），应用无需手写 JSON 即可构建请求体、解析风险结果。

是什么：

- 与数美风控 API 契约对齐的 DTO/模型层（`appId`、`accessKey`、`type`、`data`、风险 `code`/`score`/`riskLevel`、命中 `detail` 等）；
- 对 Jackson 友好：所有模型均带 `@JsonProperty` 与 `@JsonInclude(NON_NULL)` 注解。

不是什么：

- 不是 HTTP 客户端。`feature/2.0.x` 分支仅提供模型层；OkHttp 虽已声明为依赖，但本分支尚未实现传输层。

典型场景：

| 场景 | 本 SDK 的作用 |
| :--- | :--- |
| 文本审核 | 构建 `AntiFraudTextRequest` 并序列化为 JSON，调用数美接口后解析 `AntiFraudResponse` |
| 图片审核 | 构建 `AntiFraudImageRequest`（单张 `img` 或批量 `imgs`），解析 `AntiFraudImageResponse` / `BatchAntiFraudImageResponse` |
| 视频审核 | 构建 `AntiFraudVideoRequest`（`imgType`、`audioType`、`subtitleType`），解析 `AntiFraudVideoResponse` |
| 风险决策 | `AntiFraudResponse` 的 `isSuccess()` / `isPass()` / `isReview()` / `isReject()` 封装了数美结果语义 |

## 2. 功能与状态

| 能力 | 状态 | 说明 |
| :--- | :--- | :--- |
| 文本反欺诈请求模型 | 已实现 | `AntiFraudTextRequest` + `AntiFraudTextRequestData` |
| 图片反欺诈请求模型 | 已实现 | `AntiFraudImageRequest` + `AntiFraudImageRequestData`（单张 `img` / 批量 `imgs`） |
| 视频反欺诈请求模型 | 已实现 | `AntiFraudVideoRequest` + `AntiFraudVideoRequestData` |
| 带风险语义的响应模型 | 已实现 | `AntiFraudResponse`、`AntiFraudImageResponse`、`BatchAntiFraudImageResponse`、`AntiFraudVideoResponse` |
| 风险详情/命中模型 | 已实现 | `AntiFraudDetail`、`AntiFraudImageDetail`、`AntiFraudImageDetailHits`、`BatchAntiFraudImageItem` |
| HTTP 传输客户端 | 未实现 | pom 已声明 OkHttp 4.9.3，但本分支尚无客户端类 |
| 单元测试 | 暂无 | pom 已配置 JaCoCo 90% 行覆盖率门禁（不阻断构建） |

## 3. 环境要求与兼容性

| 项目 | 要求 |
| :--- | :--- |
| JDK | 17+ |
| Maven | 3.0+（内置 Maven Wrapper `mvnw`） |
| 依赖 | okhttp 4.9.3、jackson-databind 2.17.2、slf4j-api 2.0.18、lombok（provided） |

版本线：

| 分支 | JDK | 版本模式 |
| :--- | :---: | :--- |
| `feature/1.0.x` | 8 | `1.0.x.*` |
| `feature/2.0.x` | 17 | `2.0.x.*` |
| `feature/3.0.x` | 21 | `3.0.x.*` |

## 4. 架构与模块

```text
+----------------+     +------------------------------+     +------------------+
| 应用代码       | --> | com.ishumei.spring.boot.model | --> | JSON 请求体      |
| (DTO 使用)     |     | AntiFraud{Text,Image,Video}  |     | (Jackson)        |
+----------------+     | Request (+ *RequestData)     |     +------------------+
                       +------------------------------+            |
                                                                   v
+----------------+     +------------------------------+     +------------------+
| 风险决策       | <-- | AntiFraud{...}Response DTO   | <-- | 数美 API         |
| isSuccess /    |     | code / score / riskLevel /   |     | (HTTP, JSON)     |
| isPass/Review/ |     | detail + 命中模型            |     |                  |
| isReject       |     +------------------------------+     +------------------+
+----------------+
```

单模块 jar。全部 20 个类位于 `com.ishumei.spring.boot.model` 包（保留厂商命名空间以保证 API 兼容）：

| 包 | 内容 |
| :--- | :--- |
| `com.ishumei.spring.boot.model` | 基础请求（`AntiFraudRequest`、`AntiFraudRequestData`），文本/图片/视频请求及其 `*RequestData`，响应（`AntiFraudResponse`、`AntiFraudImageResponse`、`BatchAntiFraudImageResponse`、`AntiFraudVideoResponse`），详情/命中模型（`AntiFraudDetail`、`AntiFraudImageDetail`、`AntiFraudImageDetailHits`、`BatchAntiFraudImageItem`、`AntiFraudTextWordPostitionsDetail`） |

## 5. 安装

在 Maven 项目中添加依赖：

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>ishumei-java-sdk</artifactId>
    <version>2.0.x.x.20260630-SNAPSHOT</version>
</dependency>
```

Gradle：

```groovy
implementation 'io.github.easy4j:ishumei-java-sdk:2.0.x.x.20260630-SNAPSHOT'
```

快照版本由项目私服提供，请在构建中配置 pom `distributionManagement` 中声明的仓库。尚未发布 Maven Central 正式版。

## 6. 快速开始

构建文本审核请求并序列化为 JSON：

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ishumei.spring.boot.model.AntiFraudTextRequest;
import com.ishumei.spring.boot.model.AntiFraudTextRequestData;

AntiFraudTextRequest request = new AntiFraudTextRequest();
request.setAccessKey("your-access-key");   // 开通数美账号服务时由数美提供
request.setType("SOCIAL");                 // ZHIBO / ECOM / GAME / NEWS / FORUM / SOCIAL

AntiFraudTextRequestData data = new AntiFraudTextRequestData();
data.setText("hello world");
data.setNickname("tester");
request.setData(data);

String json = new ObjectMapper().writeValueAsString(request);
```

预期输出（字段顺序与模型声明顺序一致）：

```json
{"appId":"default","accessKey":"your-access-key","type":"SOCIAL",
 "data":{"text":"hello world","gender":0,"nickname":"tester","isTokenSeperate":0}}
```

`appId` 默认为 `"default"`，`gender` 与 `isTokenSeperate` 默认为 `0`，`null` 字段会被省略（`@JsonInclude(NON_NULL)`）。

## 7. 配置

模型本身不携带任何运行时配置。超时、代理、重试等连接层配置属于尚未实现的传输客户端职责，因此本分支没有需要设置的配置项。

## 8. 核心用法 / API

解析数美风险响应：

```java
import com.ishumei.spring.boot.model.AntiFraudResponse;

AntiFraudResponse response = new ObjectMapper().readValue(apiBody, AntiFraudResponse.class);

boolean success = response.isSuccess();  // status == 0 && code == "1100"
boolean pass    = response.isPass();     // success && riskLevel == "PASS"
boolean review  = response.isReview();   // success && riskLevel == "REVIEW"
boolean reject  = response.isReject();   // success && riskLevel == "REJECT"

int    score    = response.getScore();       // 风险分数，取值 [0,1000]，分数越高风险越大
String riskType = response.getRiskLevel();   // PASS / REVIEW / REJECT
```

批量图片审核使用批量请求条目：

```java
import com.ishumei.spring.boot.model.AntiFraudImageRequest;
import com.ishumei.spring.boot.model.AntiFraudImageRequestItem;

AntiFraudImageRequest request = new AntiFraudImageRequest();
request.setAccessKey("your-access-key");
request.setType("GAME");
request.getData().getImgs().add(new AntiFraudImageRequestItem()); // 每个条目含 img / tokenId / btId
```

## 9. 测试与构建

```bash
./mvnw clean verify
```

构建配置：

- JaCoCo 覆盖率报告 + 行覆盖率检查规则，最低目标 90%（`haltOnFailure=false`，只报告不阻断）；
- package 阶段附加源码包与 Javadoc 包；
- 提供 `central` 发布 profile（GPG 签名 + Central 发布插件），仅用于正式发布。

说明：本分支当前没有测试源码，覆盖率门禁暂无数据可校验。

## 10. 版本与分支

项目维护三条并行版本线，各自绑定一个 JDK 基线：

| 分支 | JDK | 版本模式 | 维护状态 |
| :--- | :---: | :--- | :--- |
| `feature/1.0.x` | 8 | `1.0.x.*` | 当前开发线 |
| `feature/2.0.x` | 17 | `2.0.x.*` | 并行维护 |
| `feature/3.0.x` | 21 | `3.0.x.*` | 并行维护 |

本分支快照版本为 `2.0.x.x.20260630-SNAPSHOT`。正式版本通过 GitHub Releases 发布；Maven Central 发布已规划，尚未执行。

## 11. 贡献与许可

欢迎通过 GitHub Issue 或 Pull Request 参与贡献。所有源码基于 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt) 许可。
