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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Per-image result entry inside a batch anti-fraud response.
 *
 * <p>Carries the verdict (code, risk level, score) for a single
 * image together with the caller-supplied {@code btId} so the
 * caller can correlate the result back to the original request.
 * Three convenience predicates summarise the verdict:
 * {@link #isPass()}, {@link #isReview()} and {@link #isReject()}.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see BatchAntiFraudImageResponse
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BatchAntiFraudImageItem {

	/**
	 * Caller-specified image identifier. Echoed from the
	 * corresponding {@link AntiFraudImageRequestItem#getBtId()}.
	 */
	@JsonProperty("btId")
	private String btId;

	/**
	 * Platform response code for this single image. The value
	 * {@code 1100} denotes success.
	 */
	@JsonProperty("code")
	private String code;

	/**
	 * Rich per-image verdict. Populated only when the callback URL
	 * is absent and the code is {@code 1100}.
	 */
	@JsonProperty("detail")
	private BatchAntiFraudImageDetail detail;

	/**
	 * Human-readable description of the response code.
	 */
	@JsonProperty("message")
	private String message;

	/**
	 * Globally unique identifier of the request.
	 */
	@JsonProperty("requestId")
	private String requestId;

	/**
	 * Coarse-grained risk verdict for this single image. Possible
	 * values are {@code PASS}, {@code REVIEW} and {@code REJECT}.
	 */
	@JsonProperty("riskLevel")
	private String riskLevel;

	/**
	 * Numeric risk score for this single image, in the range
	 * {@code [0, 1000]}.
	 */
	@JsonProperty("score")
	private int score;

	/**
	 * Reports whether the image is normal and should be allowed
	 * through.
	 *
	 * @return {@code true} when {@link #code} equals {@code "1100"}
	 *         and {@link #riskLevel} equals {@code "PASS"}.
	 */
	public boolean isPass() {
		return code.equals("1100") && riskLevel.equals("PASS");
	}

	/**
	 * Reports whether the image is suspicious and should be reviewed
	 * manually.
	 *
	 * @return {@code true} when {@link #code} equals {@code "1100"}
	 *         and {@link #riskLevel} equals {@code "REVIEW"}.
	 */
	public boolean isReview() {
		return code.equals("1100") && riskLevel.equals("REVIEW");
	}

	/**
	 * Reports whether the image is a violation and should be blocked
	 * immediately.
	 *
	 * @return {@code true} when {@link #code} equals {@code "1100"}
	 *         and {@link #riskLevel} equals {@code "REJECT"}.
	 */
	public boolean isReject() {
		return code.equals("1100") && riskLevel.equals("REJECT");
	}

}