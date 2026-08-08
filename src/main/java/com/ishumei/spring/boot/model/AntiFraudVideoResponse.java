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

/**
 * Response envelope returned when an asynchronous video inspection
 * task is submitted.
 *
 * <p>Because the verdict is computed asynchronously this envelope
 * only acknowledges the submission with a {@code code}, a
 * {@code message} and a {@code requestId} for tracing. The detailed
 * verdict is delivered later through the configured callback URL or
 * via the polling endpoint.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see AntiFraudVideoRequest
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AntiFraudVideoResponse {

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

}