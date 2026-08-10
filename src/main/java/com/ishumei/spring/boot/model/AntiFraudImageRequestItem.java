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

/**
 * Single entry inside a batch image-inspection request.
 *
 * <p>Each item combines a binary image (or URL) with the minimum
 * context required by the platform &mdash; a {@code tokenId} for
 * behaviour analytics and a {@code btId} for callback correlation.
 * Used inside {@code AntiFraudImageRequestData.imgs}.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AntiFraudImageRequestData
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageRequestItem {

	/**
	 * Image to be inspected. May be a base-64 string or a URL.
	 * Supported formats and recommended resolutions are documented
	 * at {@link AntiFraudImageRequestData}.
	 */
	@JsonProperty("img")
	private String img;

	/**
	 * Globally-unique identifier of the end-user. <strong>Strongly
	 * recommended</strong> &mdash; different users must use distinct
	 * values.
	 */
	@JsonProperty("tokenId")
	private String tokenId;

	/**
	 * Caller-specified image identifier. Echoed back in the callback
	 * request when a callback URL has been configured. Special
	 * characters are not allowed.
	 */
	@JsonProperty("btId")
	private String btId;

}