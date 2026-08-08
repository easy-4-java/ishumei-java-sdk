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
 * Detailed risk description attached to a synchronous anti-fraud
 * verdict.
 *
 * <p>Wrapped under the {@code detail} string property of
 * {@link AntiFraudResponse} and exposed here so callers can serialise
 * the payload back to objects when the platform evolves the schema.
 * The {@code @EqualsAndHashCode(callSuper = false)} annotation
 * keeps the equality contract local (the parent class does not
 * participate) which simplifies JSON round-tripping.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see AntiFraudResponse
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudDetail {

	/**
	 * Numeric identifier of the risk category. Notable values include
	 * <ul>
	 *     <li>{@code 0} &mdash; normal,</li>
	 *     <li>{@code 100} &mdash; politically sensitive,</li>
	 *     <li>{@code 200} &mdash; pornographic,</li>
	 *     <li>{@code 210} &mdash; erotic / suggestive,</li>
	 *     <li>{@code 300} &mdash; advertising,</li>
	 *     <li>{@code 310} &mdash; QR code,</li>
	 *     <li>{@code 320} &mdash; watermark,</li>
	 *     <li>{@code 400} &mdash; violence / terror,</li>
	 *     <li>{@code 500} &mdash; violation,</li>
	 *     <li>{@code 510} &mdash; undesirable scene,</li>
	 *     <li>{@code 700} &mdash; blacklist,</li>
	 *     <li>{@code 710} &mdash; whitelist,</li>
	 *     <li>{@code 800} &mdash; high-risk account,</li>
	 *     <li>{@code 900} &mdash; custom rule.</li>
	 * </ul>
	 */
	@JsonProperty("riskType")
	private int riskType;

	/**
	 * Strategy / rule identifier that triggered the verdict. <em>Legacy
	 * API parameter, retained for backwards compatibility &mdash; do not
	 * build business logic on top of it.</em>
	 */
	@JsonProperty("model")
	private String model;

	/**
	 * Human-readable explanation of the risk reason. The platform
	 * reserves the right to change this copy at any time; <strong>do
	 * not</strong> parse it programmatically.
	 */
	@JsonProperty("description")
	private String description;

	/**
	 * Newer version of {@link #description} returned by updated policy
	 * rules. Present only for rules that have been migrated to the
	 * V2 schema.
	 */
	@JsonProperty("descriptionV2")
	private String descriptionV2;

}