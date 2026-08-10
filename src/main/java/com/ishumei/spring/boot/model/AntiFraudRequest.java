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
 * Base authentication envelope shared by every Ishumei anti-fraud request.
 *
 * <p>This class carries the three mandatory fields that authenticate a
 * caller with the Ishumei platform &mdash; {@code appId},
 * {@code accessKey} and {@code type} &mdash; and is intended to be
 * extended by concrete request types (text, image, video) that add a
 * {@code data} payload. Lombok's {@link Data} annotation generates the
 * canonical accessors and mutators; Jackson's {@link JsonInclude}
 * configuration omits {@code null} properties from the serialised JSON
 * so callers can build minimal payloads.</p>
 *
 * <p>Sample serialised form:</p>
 * <pre>
 * {
 *   "appId":     "default",
 *   "accessKey": "your-key",
 *   "type":      "ECOM"
 * }
 * </pre>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AntiFraudTextRequest
 * @see AntiFraudImageRequest
 * @see AntiFraudVideoRequest
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AntiFraudRequest {

	/**
	 * Application identifier used to distinguish between multiple applications
	 * owned by the same organisation. The default value {@code "default"} is
	 * applied automatically and may be overridden when the same company
	 * operates more than one integration with Ishumei.
	 */
	@JsonProperty("appId")
	private String appId = "default";

	/**
	 * Account secret issued by Ishumei when the service is provisioned.
	 * This credential authorises every API call and must be kept
	 * confidential on the client side.
	 */
	@JsonProperty("accessKey")
	private String accessKey;

	/**
	 * Platform business type. Accepted values (uppercase) are
	 * <ul>
	 *     <li>{@code ZHIBO} &mdash; live streaming,</li>
	 *     <li>{@code ECOM} &mdash; e-commerce,</li>
	 *     <li>{@code GAME} &mdash; gaming,</li>
	 *     <li>{@code NEWS} &mdash; news / media,</li>
	 *     <li>{@code FORUM} &mdash; forums,</li>
	 *     <li>{@code SOCIAL} &mdash; social networks.</li>
	 * </ul>
	 */
	@JsonProperty("type")
	private String type;

}