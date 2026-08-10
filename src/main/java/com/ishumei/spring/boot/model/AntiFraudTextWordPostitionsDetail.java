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
 * Per-hit position record returned by the text anti-fraud endpoint
 * when keyword-based rules fire.
 *
 * <p>The {@code word} property holds the sensitive term that was
 * matched and {@code position} carries the byte / character offsets
 * where the hit was found, allowing callers to highlight the
 * offending span inside the original input.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AntiFraudTextRequestData
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudTextWordPostitionsDetail {

	/**
	 * Sensitive word / token that was matched by the keyword rule.
	 */
	@JsonProperty("word")
	private String word;

	/**
	 * Location of the hit inside the original input. The platform
	 * returns the offsets as a stringified range (e.g.
	 * {@code "0-4"}); callers should parse it before using the
	 * numbers programmatically.
	 */
	@JsonProperty("position")
	private String position;

}