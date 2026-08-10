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
 * Synchronous image anti-fraud request envelope.
 *
 * <p>Extends {@link AntiFraudRequest} with the {@code data} payload
 * specific to the image endpoint. The serialized JSON body should not
 * exceed 1 MB; larger payloads should be migrated to the asynchronous
 * batch endpoint.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AntiFraudRequest
 * @see AntiFraudImageRequestData
 * @see AntiFraudImageResponse
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageRequest extends AntiFraudRequest {

	/**
	 * Image payload (single image or batch). Payload size must remain
	 * under 1 MB.
	 */
	@JsonProperty("data")
	private AntiFraudImageRequestData data;

}