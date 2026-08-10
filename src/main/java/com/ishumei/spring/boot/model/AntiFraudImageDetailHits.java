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
 * Single strategy-rule hit returned by the V2 rules engine.
 *
 * <p>Each hit captures the rule that fired together with the score
 * contribution and the human-readable description. The collection of
 * hits is attached under {@code AntiFraudImageDetail.hits}.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AntiFraudImageDetail
 * @see BatchAntiFraudImageDetailHits
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageDetailHits {

	/**
	 * Human-readable explanation of the rule. <strong>Do not</strong>
	 * parse this copy programmatically.
	 */
	@JsonProperty("description")
	private String description;

	/**
	 * Newer (V2) version of {@link #description} used by migrated
	 * policies.
	 */
	@JsonProperty("descriptionV2")
	private String descriptionV2;

	/**
	 * Strategy / rule identifier. <em>Legacy field, retained for
	 * backwards compatibility &mdash; do not depend on it.</em>
	 */
	@JsonProperty("model")
	private String model;

	/**
	 * Coarse-grained risk verdict of this specific hit. Possible
	 * values are {@code PASS}, {@code REVIEW} and {@code REJECT}.
	 */
	@JsonProperty("riskLevel")
	private String riskLevel;

	/**
	 * Numeric identifier of the risk category. See
	 * {@link AntiFraudDetail#getRiskType()} for the full enumeration.
	 */
	@JsonProperty("riskType")
	private int riskType;

	/**
	 * Numeric risk score contributed by this hit, in the range
	 * {@code [0, 1000]}.
	 */
	@JsonProperty("score")
	private int score;

}