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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Asynchronous video anti-fraud request envelope.
 *
 * <p>Extends {@link AntiFraudRequest} with the media-type toggles
 * and the {@code data} payload specific to the video endpoint. The
 * platform returns a {@code taskId} that the caller polls (or
 * receives via the configured callback) for the final verdict.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see AntiFraudRequest
 * @see AntiFraudVideoRequestData
 * @see AntiFraudVideoResponse
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudVideoRequest extends AntiFraudRequest {

	/**
	 * Toggles image-frame inspection. Accepted values are negotiated
	 * with Ishumei during onboarding.
	 */
	@JsonProperty("imgType")
	private String imgType;

	/**
	 * Toggles audio-stream inspection. Accepted values are negotiated
	 * with Ishumei during onboarding.
	 */
	@JsonProperty("audioType")
	private String audioType;

	/**
	 * Toggles subtitle / OCR inspection. Accepted values are
	 * negotiated with Ishumei during onboarding.
	 */
	@JsonProperty("subtitleType")
	private String subtitleType;

	/**
	 * Caller-specified video identifier. Echoed back in the callback
	 * request when a callback URL has been configured. Special
	 * characters are not allowed.
	 */
	@JsonProperty("btId")
	private String btId;

	/**
	 * Video payload (URL plus optional metadata). Payload size must
	 * remain under 1 MB.
	 */
	@JsonProperty("data")
	private AntiFraudVideoRequestData data;

}