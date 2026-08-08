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
 * Single strategy-rule hit inside the per-image detail of a batch
 * anti-fraud response.
 *
 * <p>Field-for-field equivalent to
 * {@link AntiFraudImageDetailHits} but typed against the batch detail
 * hierarchy so that callers can rely on consistent generic
 * signatures.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see BatchAntiFraudImageDetail
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchAntiFraudImageDetailHits {

	/** Human-readable explanation of the rule. Do not parse programmatically. */
	@JsonProperty("description")
	private String description;

	/** Newer (V2) version of {@link #description}. */
	@JsonProperty("descriptionV2")
	private String descriptionV2;

	/** Strategy / rule identifier. Legacy field &mdash; do not depend on it. */
	@JsonProperty("model")
	private String model;

	/** Coarse-grained risk verdict of this hit ({@code PASS}, {@code REVIEW}, {@code REJECT}). */
	@JsonProperty("riskLevel")
	private String riskLevel;

	/** Numeric identifier of the risk category. See {@link AntiFraudDetail}. */
	@JsonProperty("riskType")
	private int riskType;

	/** Numeric risk score contributed by this hit ({@code [0, 1000]}). */
	@JsonProperty("score")
	private int score;

}