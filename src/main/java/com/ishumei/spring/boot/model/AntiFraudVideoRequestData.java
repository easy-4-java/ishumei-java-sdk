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
 * Video-specific payload for the asynchronous anti-fraud endpoint.
 *
 * <p>Carries the {@code url} of the remote video together with the
 * optional metadata fields inherited from
 * {@link AntiFraudRequestData}. The platform downloads the file
 * itself and runs the inspection asynchronously.</p>
 *
 * <p>Legacy commented-out fields (detectFrequency, videoName, ip,
 * tokenId) are intentionally retained as historical reference and
 * are not part of the public API.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AntiFraudVideoRequest
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudVideoRequestData extends AntiFraudRequestData {

	/**
	 * Public URL of the video to be inspected. The platform will
	 * fetch the file directly from this address; private storage
	 * buckets must therefore expose a signed URL.
	 */
	@JsonProperty("url")
	private String url;

}