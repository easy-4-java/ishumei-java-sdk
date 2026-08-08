/*
 * Copyright (c) 2018-present, easy-4-java (https://github.com/easy-4-java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ishumei.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

/**
 * Response envelope returned by the synchronous image anti-fraud
 * endpoint.
 *
 * <p>Unlike the text counterpart this response also exposes an
 * asynchronous {@code taskId} that lets callers poll for the
 * detailed verdict, and the {@link #detail} property is already
 * deserialised into {@link AntiFraudImageDetail}.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see AntiFraudImageRequest
 * @see AntiFraudImageDetail
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AntiFraudImageResponse {

	/**
	 * Platform response code. {@code 1100} denotes success.
	 */
	@JsonProperty("code")
	private String code;

	/**
	 * Human-readable description of the response code.
	 */
	@JsonProperty("message")
	private String message;

	/**
	 * Globally unique identifier of the request.
	 */
	@JsonProperty("requestId")
	private String requestId;

	/**
	 * Numeric risk score in the range {@code [0, 1000]}. Higher
	 * values indicate greater risk.
	 */
	@JsonProperty("score")
	private int score;

	/**
	 * Coarse-grained risk verdict. Possible values are
	 * {@code PASS}, {@code REVIEW} and {@code REJECT}.
	 */
	@JsonProperty("riskLevel")
	private String riskLevel;

	/**
	 * Server-side timeout flag. {@code 0} denotes a normal response,
	 * {@code 501} indicates the platform timed out while computing the
	 * score.
	 */
	@JsonProperty("status")
	private int status;

	/**
	 * Asynchronous task identifier. Useful for polling the platform
	 * for the detailed verdict when the synchronous call timed out.
	 */
	@JsonProperty("taskId")
	private String taskId;

	/**
	 * Rich per-image verdict (already deserialised). See
	 * {@link AntiFraudImageDetail} for the available fields.
	 */
	@JsonProperty("detail")
	private AntiFraudImageDetail detail;

	/**
	 * Reports whether the call succeeded without a timeout and the
	 * platform returned code {@code 1100}.
	 *
	 * @return {@code true} when {@link #status} is {@code 0} and
	 *         {@link #code} equals {@code "1100"}.
	 */
	public boolean isSuccess() {
		return status == 0 && Objects.nonNull(code) && code.equals("1100");
	}

	/**
	 * Reports whether the response indicates the image is normal and
	 * should be allowed through.
	 *
	 * @return {@code true} when {@link #isSuccess()} returns
	 *         {@code true} and {@link #riskLevel} equals
	 *         {@code "PASS"}.
	 */
	public boolean isPass() {
		return isSuccess() && riskLevel.equals("PASS");
	}

	/**
	 * Reports whether the response indicates the image is suspicious
	 * and should be reviewed manually.
	 *
	 * @return {@code true} when {@link #isSuccess()} returns
	 *         {@code true} and {@link #riskLevel} equals
	 *         {@code "REVIEW"}.
	 */
	public boolean isReview() {
		return isSuccess() && riskLevel.equals("REVIEW");
	}

	/**
	 * Reports whether the response indicates the image is a
	 * violation and should be blocked immediately.
	 *
	 * @return {@code true} when {@link #isSuccess()} returns
	 *         {@code true} and {@link #riskLevel} equals
	 *         {@code "REJECT"}.
	 */
	public boolean isReject() {
		return isSuccess() && riskLevel.equals("REJECT");
	}

}