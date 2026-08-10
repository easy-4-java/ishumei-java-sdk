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
 * Text-specific payload for the synchronous anti-fraud endpoint.
 *
 * <p>Carries the free-form {@code text} to be inspected together
 * with optional metadata (gender, nickname, room) that helps the
 * scoring engine adapt the policy. The text is capped at 20 000
 * characters.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AntiFraudTextRequest
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudTextRequestData extends AntiFraudRequestData {

	/**
	 * Free-form text to be inspected. Up to 20 000 characters.
	 */
	@JsonProperty("text")
	private String text;

	/**
	 * End-user gender. Possible values are {@code 0} (female) and
	 * {@code 1} (male).
	 */
	@JsonProperty("gender")
	private int gender;

	/**
	 * End-user nickname. <strong>Strongly recommended</strong> &mdash;
	 * abusive users frequently broadcast politically-sensitive or
	 * advertorial content through nicknames, so providing it
	 * materially improves detection accuracy.
	 */
	@JsonProperty("nickname")
	private String nickname;

	/**
	 * Live-streaming / game-room identifier. Allows per-room policy
	 * tuning.
	 */
	@JsonProperty("room")
	private String room;

	/**
	 * Whether account tokens should be scoped per application.
	 * Possible values are {@code 0} (do not separate, default) and
	 * {@code 1} (separate). When set to {@code 1} accounts in
	 * different applications are tracked independently and
	 * account-related strategy features do not bleed across
	 * applications.
	 */
	@JsonProperty("isTokenSeperate")
	private int isTokenSeperate = 0;

}