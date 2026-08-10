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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Per-image detail returned inside a batch anti-fraud response.
 *
 * <p>Mirrors the field set of {@link AntiFraudImageDetail} but
 * additionally carries the {@code tokenScore} aggregated by the
 * batch endpoint &mdash; a token-level score that summarises the
 * behaviour across the entire batch for a single user.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see BatchAntiFraudImageResponse
 * @see AntiFraudImageDetail
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchAntiFraudImageDetail {

	/** Human-readable explanation of the risk reason. Do not parse programmatically. */
	@JsonProperty("description")
	private String description;

	/** Newer (V2) version of {@link #description}. */
	@JsonProperty("descriptionV2")
	private String descriptionV2;

	/** OCR text recognised inside the image. */
	@JsonProperty("text")
	private String text;

	/** Pornographic-recognition label. */
	@JsonProperty("pornLabel")
	private String pornLabel;

	/** Probability that the image is pornographic (0.0 &ndash; 1.0). */
	@JsonProperty("pornRate")
	private float pornRate;

	/** Probability that the image is erotic / suggestive (0.0 &ndash; 1.0). */
	@JsonProperty("sexyRate")
	private float sexyRate;

	/** Probability that the image is normal (0.0 &ndash; 1.0). */
	@JsonProperty("normalRate")
	private float normalRate;

	/** Name of the closest politically-sensitive figure matched. */
	@JsonProperty("polityName")
	private String polityName;

	/** Probability of the closest politically-sensitive match (0.0 &ndash; 1.0). */
	@JsonProperty("polityRate")
	private float polityRate;

	/** Violence-recognition label. See {@link AntiFraudImageDetail} for possible values. */
	@JsonProperty("violenceLabel")
	private String violenceLabel;

	/** Probability that the image contains a riot scene. */
	@JsonProperty("rebelRate")
	private float rebelRate;

	/** Probability that the image contains a national flag or emblem. */
	@JsonProperty("flagRate")
	private float flagRate;

	/** Probability that the image contains a military uniform. */
	@JsonProperty("armyRate")
	private float armyRate;

	/** Probability that the image contains a terrorist-organisation symbol. */
	@JsonProperty("terrorismRate")
	private float terrorismRate;

	/** Probability that the image contains a weapon (gun or knife). */
	@JsonProperty("weaponRate")
	private float weaponRate;

	/** Probability that the image contains a bloody scene. */
	@JsonProperty("bloodRate")
	private float bloodRate;

	/** Probability that the image contains a game-style weapon. */
	@JsonProperty("gameWeaponRate")
	private float gameWeaponRate;

	/** Probability that the image contains a China map. */
	@JsonProperty("chinamapRate")
	private float chinamapRate;

	/** Probability that the image contains a tank. */
	@JsonProperty("tankRate")
	private float tankRate;

	/** Probability that the image contains candles. */
	@JsonProperty("candleRate")
	private float candleRate;

	/** Probability that the image contains a uniform. */
	@JsonProperty("uniformRate")
	private float uniformRate;

	/** Probability that the image is non-violent (normal). */
	@JsonProperty("nonViolenceRate")
	private float nonViolenceRate;

	/** List of strategy-rule hits returned by the V2 rules engine. */
	@JsonProperty("hits")
	private List<BatchAntiFraudImageDetailHits> hits;

	/** Strategy / rule identifier. Legacy field &mdash; do not depend on it. */
	@JsonProperty("model")
	private String model;

	/** Numeric identifier of the risk category. See {@link AntiFraudDetail}. */
	@JsonProperty("riskType")
	private int riskType;

	/** Original text recognised by OCR (before any platform-side normalisation). */
	@JsonProperty("original_text")
	private String originalText;

	/** Token-id associated with the erotic-risk hit. */
	@JsonProperty("sexy_risk_tokenid")
	private int sexyRiskTokenId;

	/** Aggregated token-level risk score across the whole batch for a single user. */
	@JsonProperty("tokenScore")
	private int tokenScore;

}