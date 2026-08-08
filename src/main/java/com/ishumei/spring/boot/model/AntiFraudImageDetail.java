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

import java.util.List;

/**
 * Rich per-image detail attached to a synchronous anti-fraud image
 * verdict.
 *
 * <p>Wrapped under the {@code detail} object of
 * {@link AntiFraudImageResponse} and contains the platform's
 * category probabilities (pornographic, erotic, normal, political,
 * violent, ...) plus the {@code hits} list returned by the new
 * strategy rules. Properties are only populated when the
 * corresponding risk category is relevant to the configured policy,
 * which is why {@link JsonInclude.Include#NON_NULL} is configured at
 * the class level.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see AntiFraudImageResponse
 * @see AntiFraudImageDetailHits
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageDetail {

	/**
	 * Human-readable explanation of the risk reason. <strong>Do not</strong>
	 * parse this copy programmatically &mdash; it may change without notice.
	 */
	@JsonProperty("description")
	private String description;

	/**
	 * Newer (V2) version of {@link #description}. Populated only by
	 * rules that have been migrated to the V2 schema.
	 */
	@JsonProperty("descriptionV2")
	private String descriptionV2;

	/**
	 * OCR text recognised inside the image. Returned only when the
	 * OCR feature has been enabled in the policy.
	 */
	@JsonProperty("text")
	private String text;

	/**
	 * Pornographic-recognition label. Possible values are
	 * {@code "色情"} (pornographic), {@code "性感"} (erotic),
	 * {@code "正常"} (normal).
	 */
	@JsonProperty("pornLabel")
	private String pornLabel;

	/**
	 * Probability that the image is pornographic (0.0 &ndash; 1.0).
	 */
	@JsonProperty("pornRate")
	private float pornRate;

	/**
	 * Probability that the image is erotic / suggestive (0.0 &ndash; 1.0).
	 */
	@JsonProperty("sexyRate")
	private float sexyRate;

	/**
	 * Probability that the image is normal (0.0 &ndash; 1.0).
	 */
	@JsonProperty("normalRate")
	private float normalRate;

	/**
	 * Name of the closest politically-sensitive figure matched against
	 * the image, if any.
	 */
	@JsonProperty("polityName")
	private String polityName;

	/**
	 * Probability of the closest politically-sensitive match (0.0 &ndash; 1.0).
	 */
	@JsonProperty("polityRate")
	private float polityRate;

	/**
	 * Violence-recognition label. Possible values include
	 * {@code "暴乱场景"}, {@code "国旗国徽"}, {@code "军装"},
	 * {@code "恐怖组织"}, {@code "枪支刀具"}, {@code "血腥场景"},
	 * {@code "游戏枪支刀具"}, {@code "中国地图"}, {@code "坦克"},
	 * {@code "蜡烛"}, {@code "制服"} and {@code "正常"}.
	 */
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

	/**
	 * List of strategy-rule hits returned by the V2 rules engine.
	 * Populated only for migrated policies.
	 */
	@JsonProperty("hits")
	private List<AntiFraudImageDetailHits> hits;

	/**
	 * Strategy / rule identifier that triggered the verdict.
	 * <em>Legacy field, retained for backwards compatibility &mdash;
	 * do not depend on it.</em>
	 */
	@JsonProperty("model")
	private String model;

	/**
	 * Numeric identifier of the risk category. See
	 * {@link AntiFraudDetail#getRiskType()} for the full enumeration.
	 */
	@JsonProperty("riskType")
	private int riskType;

	/**
	 * Original text recognised by OCR (before any platform-side
	 * normalisation).
	 */
	@JsonProperty("original_text")
	private String originalText;

	/**
	 * Token-id associated with the erotic-risk hit.
	 */
	@JsonProperty("sexy_risk_tokenid")
	private int sexyRiskTokenId;

	/**
	 * Identifier of the upstream data source that produced the
	 * verdict (policy cluster / model family).
	 */
	@JsonProperty("riskSource")
	private int riskSource;

}