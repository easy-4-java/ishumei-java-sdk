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
 * Common user-context fields shared by every anti-fraud payload
 * (text, image and video).
 *
 * <p>All properties are optional but the Ishumei scoring engine
 * performs significantly better when more context is provided. In
 * particular {@code tokenId}, {@code ip} and {@code deviceId} form
 * the canonical trio used for cross-channel user behaviour analysis.
 * Lombok's {@link Data} generates the standard accessors and
 * mutators; null properties are excluded from the serialised JSON
 * payload.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AntiFraudTextRequestData
 * @see AntiFraudImageRequestData
 * @see AntiFraudVideoRequestData
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AntiFraudRequestData {

	/**
	 * Globally-unique identifier of the end-user. It is <strong>strongly
	 * recommended</strong> to pass the application-side UID &mdash; different
	 * users must use distinct {@code tokenId} values so that behaviour
	 * analytics and blacklist lookups behave correctly.
	 */
	@JsonProperty("tokenId")
	private String tokenId;

	/**
	 * Business scenario label negotiated with Ishumei. Different channels
	 * route through different risk models.
	 */
	@JsonProperty("channel")
	private String channel;

	/**
	 * Client IP address. Used for IP-based user behaviour analysis and to
	 * correlate requests with IP-level blacklists.
	 */
	@JsonProperty("ip")
	private String ip;

	/**
	 * End-user mobile phone number. May be cross-referenced against
	 * Ishumei's phone-number blacklist.
	 */
	@JsonProperty("phone")
	private String phone;

	/**
	 * <strong>Strongly recommended.</strong> Ishumei device-fingerprint
	 * identifier. Persists across MAC / IMEI tampering and lets the
	 * platform associate malicious users that rotate device metadata.
	 */
	@JsonProperty("deviceId")
	private String deviceId;

	/**
	 * Client IP address used for receiving-token correlation. Mirrors
	 * {@link #ip} but lets the upstream gateway reuse a token received
	 * from another channel.
	 */
	@JsonProperty("receiveTokenId")
	private String receiveTokenId;

	/**
	 * User tier / grade. Different grades can be configured with
	 * different interception strategies (for example, VIP users may
	 * tolerate higher risk scores).
	 */
	@JsonProperty("level")
	private String level;

	/**
	 * Account registration timestamp. <strong>Strongly recommended</strong>
	 * because brand-new accounts present a meaningfully higher
	 * risk profile.
	 */
	@JsonProperty("registerTime")
	private String registerTime;

	/**
	 * Number of friends / contacts of the account. Social scenarios
	 * are encouraged to provide this metric as an indicator of user
	 * quality.
	 */
	@JsonProperty("friendNum")
	private String friendNum;

	/**
	 * Number of followers of the account. Live-streaming and
	 * community scenarios are encouraged to provide this metric as
	 * an indicator of user quality.
	 */
	@JsonProperty("fansNum")
	private String fansNum;

	/**
	 * User role. Different roles can be tied to different interception
	 * strategies. Notable values include
	 * <ul>
	 *     <li>{@code ADMIN} &mdash; moderator / administrator,</li>
	 *     <li>{@code HOST} &mdash; live-stream host,</li>
	 *     <li>{@code SYSTEM} &mdash; system role,</li>
	 *     <li>{@code USER} &mdash; ordinary user (default).</li>
	 * </ul>
	 */
	@JsonProperty("role")
	private String role = "USER";

	/**
	 * Topic / thread identifier under discussion (for example, a
	 * book-review area or forum post id).
	 */
	@JsonProperty("topic")
	private String topic;

	/**
	 * Whether the account is premium (paid). Possible values are
	 * {@code 1} (premium) and {@code 0} (default / non-premium).
	 */
	@JsonProperty("isPremiumUser")
	private int isPremiumUser = 0;

}