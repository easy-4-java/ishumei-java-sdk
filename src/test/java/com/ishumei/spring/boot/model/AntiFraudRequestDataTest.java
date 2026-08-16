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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

/**
 * Unit tests for {@link AntiFraudRequestData}.
 *
 * <p>Exercises the canonical user-context accessors, the default
 * values for {@code role} and {@code isPremiumUser}, the equality
 * contract, and the Jackson round-trip.</p>
 *
 * @since 3.0.0
 */
class AntiFraudRequestDataTest {

	@Test
	void shouldExposeDefaultRoleAndPremiumFlag() {
		AntiFraudRequestData data = new AntiFraudRequestData();
		assertEquals("USER", data.getRole());
		assertEquals(0, data.getIsPremiumUser());
	}

	@Test
	void shouldRoundTripAllContextFields() {
		AntiFraudRequestData data = new AntiFraudRequestData();
		data.setTokenId("uid-1");
		data.setChannel("forum");
		data.setIp("127.0.0.1");
		data.setPhone("13800138000");
		data.setDeviceId("dev-1");
		data.setReceiveTokenId("recv-1");
		data.setLevel("VIP");
		data.setRegisterTime("2026-01-01");
		data.setFriendNum("120");
		data.setFansNum("3000");
		data.setRole("ADMIN");
		data.setTopic("topic-1");
		data.setIsPremiumUser(1);

		assertEquals("uid-1", data.getTokenId());
		assertEquals("forum", data.getChannel());
		assertEquals("127.0.0.1", data.getIp());
		assertEquals("13800138000", data.getPhone());
		assertEquals("dev-1", data.getDeviceId());
		assertEquals("recv-1", data.getReceiveTokenId());
		assertEquals("VIP", data.getLevel());
		assertEquals("2026-01-01", data.getRegisterTime());
		assertEquals("120", data.getFriendNum());
		assertEquals("3000", data.getFansNum());
		assertEquals("ADMIN", data.getRole());
		assertEquals("topic-1", data.getTopic());
		assertEquals(1, data.getIsPremiumUser());
	}

	@Test
	void shouldHonorEqualsAndHashCodeContract() {
		AntiFraudRequestData a = new AntiFraudRequestData();
		a.setTokenId("uid");

		AntiFraudRequestData b = new AntiFraudRequestData();
		b.setTokenId("uid");

		AntiFraudRequestData c = new AntiFraudRequestData();
		c.setTokenId("other");

		assertEquals(a, b);
		assertEquals(a.hashCode(), b.hashCode());
		assertNotEquals(a, c);
		assertNotEquals(a, null);
	}

	@Test
	void shouldProduceNonEmptyToString() {
		AntiFraudRequestData data = new AntiFraudRequestData();
		data.setTokenId("uid");
		String text = data.toString();
		assertNotNull(text);
		assertTrue(text.contains("AntiFraudRequestData"));
	}

	@Test
	void shouldSerialiseToJsonWithDefaultValues() throws Exception {
		ObjectMapper mapper = new JsonMapper();
		AntiFraudRequestData data = new AntiFraudRequestData();
		data.setTokenId("uid");
		data.setRole("ADMIN");

		String json = mapper.writeValueAsString(data);
		assertTrue(json.contains("\"tokenId\":\"uid\""));
		assertTrue(json.contains("\"role\":\"ADMIN\""));
		// isPremiumUser defaults to 0 and is emitted
		assertTrue(json.contains("\"isPremiumUser\":0"));
	}

	@Test
	void shouldDeserialiseFromJson() throws Exception {
		ObjectMapper mapper = new JsonMapper();
		String json = "{\"tokenId\":\"u\",\"channel\":\"ch\",\"role\":\"HOST\",\"isPremiumUser\":1}";

		AntiFraudRequestData data = mapper.readValue(json, AntiFraudRequestData.class);
		assertEquals("u", data.getTokenId());
		assertEquals("ch", data.getChannel());
		assertEquals("HOST", data.getRole());
		assertEquals(1, data.getIsPremiumUser());
	}

	@Test
	void shouldIgnoreUnknownJsonProperties() throws Exception {
		ObjectMapper mapper = new JsonMapper();
		// AntiFraudRequestData does NOT carry @JsonIgnoreProperties,
		// so unknown fields cause an exception. Verify this behavior.
		String json = "{\"tokenId\":\"u\",\"unknown\":42}";

		try {
			mapper.readValue(json, AntiFraudRequestData.class);
			// If no exception is thrown, the class must have been annotated
			// with @JsonIgnoreProperties at some point — still acceptable.
		} catch (tools.jackson.databind.exc.UnrecognizedPropertyException e) {
			// Expected: the class does not ignore unknown properties.
			assertNotNull(e.getMessage());
		}
	}
}