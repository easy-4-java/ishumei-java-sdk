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
 * Image-specific payload for the synchronous anti-fraud endpoint.
 *
 * <p>Carries either a single image ({@link #img}) or a batch of
 * images ({@link #imgs}, max 100 entries), together with the
 * device-fingerprint identifiers that improve scoring accuracy.
 * Supported formats include {@code jpg}, {@code jpeg}, {@code jp2},
 * {@code png}, {@code webp}, {@code gif}, {@code bmp}, {@code tiff},
 * {@code tif}, {@code dib}, {@code ppm}, {@code pgm}, {@code pbm},
 * {@code hdr} and {@code pic}; an image resolution of at least
 * 256&times;256 pixels is recommended.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see AntiFraudImageRequest
 * @see AntiFraudImageRequestItem
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageRequestData extends AntiFraudRequestData {

	/**
	 * Single image to be inspected. May be either the base-64
	 * encoding of the image bytes or a URL pointing to a hosted
	 * image. Supported formats are listed at the class level.
	 */
	@JsonProperty("img")
	private String img;

	/**
	 * Batch of images to be inspected. The list must contain at most
	 * 100 entries; each entry follows the format documented at
	 * {@link AntiFraudImageRequestItem}.
	 */
	@JsonProperty("imgs")
	private List<AntiFraudImageRequestItem> imgs;

	/**
	 * Caller-specified image identifier. Echoed back in the callback
	 * request when a callback URL has been configured. Special
	 * characters are not allowed.
	 */
	@JsonProperty("btId")
	private String btId;

	/**
	 * End-user gender. Possible values are {@code 0} (female) and
	 * {@code 1} (male).
	 */
	@JsonProperty("sex")
	private int sex;

	/**
	 * End-user age bucket. Possible values are
	 * {@code 0} (youth, ~18&ndash;45),
	 * {@code 1} (middle-aged, ~45&ndash;60) and
	 * {@code 2} (senior, &gt;60).
	 */
	@JsonProperty("age")
	private int age = 0;

	/**
	 * Android device identifier. IMEI / MAC survive multiple
	 * accounts and IP rotations, which makes them highly effective
	 * for tying malicious behaviour back to a single physical
	 * device &mdash; they can also be matched against Ishumei's
	 * device blacklist.
	 */
	@JsonProperty("imei")
	private String imei;

	/** MAC address of the device. Mirrors the behaviour of {@link #imei}. */
	@JsonProperty("mac")
	private String mac;

	/**
	 * iOS application identifier. Unlike {@code tokenId} or IP,
	 * {@code idfv} cannot be modified by the user and is therefore
	 * a strong correlation signal.
	 */
	@JsonProperty("idfv")
	private String idfv;

	/** iOS advertising identifier. Mirrors the behaviour of {@link #idfv}. */
	@JsonProperty("idfa")
	private String idfa;

	/**
	 * Maximum number of frames sampled from a GIF animation. Defaults
	 * to {@code 20}. When {@code interval * maxFrame} is smaller than
	 * the actual frame count, the interval is automatically widened
	 * to {@code frameCount / maxFrame}.
	 */
	@JsonProperty("maxFrame")
	private int maxFrame = 20;

	/**
	 * Sampling interval for GIF inspection &mdash; every
	 * {@code interval}-th frame is fed to the model. Defaults to
	 * {@code 1} (inspect every frame).
	 */
	@JsonProperty("interval")
	private int interval = 1;

}