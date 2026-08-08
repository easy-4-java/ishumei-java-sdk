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

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Response envelope returned by the batch image anti-fraud endpoint.
 *
 * <p>In addition to the per-image verdicts in {@link #imgs}, this
 * envelope exposes a {@code statistics} summary (rejected, reviewed,
 * passed and errored counts) that lets the caller quickly surface
 * batch-level KPIs without iterating through the per-image list.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see BatchAntiFraudImageItem
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BatchAntiFraudImageResponse {

	/** Platform response code. {@code 1100} denotes success. */
	@JsonProperty("code")
	private String code;

	/** Human-readable description of the response code. */
	@JsonProperty("message")
	private String message;

	/** Globally unique identifier of the request. */
	@JsonProperty("requestId")
	private String requestId;

	/**
	 * Per-image verdicts. Populated only when the response code is
	 * {@code 1100}.
	 */
	@JsonProperty("imgs")
	private List<BatchAntiFraudImageItem> imgs;

	/**
	 * Integer array of length {@code 4} summarising the batch
	 * &mdash; rejected, reviewed, passed (populated only when the
	 * code is {@code 1100}) and errored counts.
	 */
	@JsonProperty("statistics")
	private List<Integer> statistics;

	/**
	 * Reports whether the call succeeded and the platform returned
	 * the canonical success code {@code 1100}.
	 *
	 * @return {@code true} when {@link #code} equals {@code "1100"}.
	 */
	public boolean isSuccess() {
		return Objects.nonNull(code) && code.equals("1100");
	}

}