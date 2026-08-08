package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AntiFraudRequest} and {@link AntiFraudRequestData}.
 */
@DisplayName("AntiFraudRequest / AntiFraudRequestData")
class AntiFraudRequestTest {

    // ── AntiFraudRequest ────────────────────────────────────────────────

    @Test
    @DisplayName("shouldDefaultAppIdToDefault")
    void shouldDefaultAppIdToDefault() {
        AntiFraudRequest req = new AntiFraudRequest();
        assertEquals("default", req.getAppId());
    }

    @Test
    @DisplayName("shouldSetAndGetAppId")
    void shouldSetAndGetAppId() {
        AntiFraudRequest req = new AntiFraudRequest();
        req.setAppId("my-app");
        assertEquals("my-app", req.getAppId());
    }

    @Test
    @DisplayName("shouldSetAndGetAccessKey")
    void shouldSetAndGetAccessKey() {
        AntiFraudRequest req = new AntiFraudRequest();
        req.setAccessKey("secret-key");
        assertEquals("secret-key", req.getAccessKey());
    }

    @Test
    @DisplayName("shouldSetAndGetType")
    void shouldSetAndGetType() {
        AntiFraudRequest req = new AntiFraudRequest();
        req.setType("ECOM");
        assertEquals("ECOM", req.getType());
    }

    @Test
    @DisplayName("shouldHaveNullAccessKeyByDefault")
    void shouldHaveNullAccessKeyByDefault() {
        AntiFraudRequest req = new AntiFraudRequest();
        assertNull(req.getAccessKey());
    }

    @Test
    @DisplayName("shouldHaveNullTypeByDefault")
    void shouldHaveNullTypeByDefault() {
        AntiFraudRequest req = new AntiFraudRequest();
        assertNull(req.getType());
    }

    @Test
    @DisplayName("shouldSupportEqualsAndHashCode")
    void shouldSupportEqualsAndHashCode() {
        AntiFraudRequest a = new AntiFraudRequest();
        a.setAccessKey("k1");
        a.setType("ECOM");

        AntiFraudRequest b = new AntiFraudRequest();
        b.setAccessKey("k1");
        b.setType("ECOM");

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportInequality")
    void shouldSupportInequality() {
        AntiFraudRequest a = new AntiFraudRequest();
        a.setType("ECOM");
        AntiFraudRequest b = new AntiFraudRequest();
        b.setType("GAME");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceMeaningfulToString")
    void shouldProduceMeaningfulToString() {
        AntiFraudRequest req = new AntiFraudRequest();
        req.setAccessKey("key");
        String s = req.toString();
        assertTrue(s.contains("accessKey=key"), "toString should contain field values");
    }

    // ── AntiFraudRequestData ────────────────────────────────────────────

    @Test
    @DisplayName("shouldCreateAntiFraudRequestDataWithDefaults")
    void shouldCreateAntiFraudRequestDataWithDefaults() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        assertNull(data.getTokenId());
        assertNull(data.getChannel());
        assertNull(data.getIp());
        assertNull(data.getPhone());
        assertNull(data.getDeviceId());
        assertNull(data.getReceiveTokenId());
        assertNull(data.getLevel());
        assertNull(data.getRegisterTime());
        assertNull(data.getFriendNum());
        assertNull(data.getFansNum());
        assertEquals("USER", data.getRole());
        assertNull(data.getTopic());
        assertEquals(0, data.getIsPremiumUser());
    }

    @Test
    @DisplayName("shouldSetAndGetTokenId")
    void shouldSetAndGetTokenId() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setTokenId("user-123");
        assertEquals("user-123", data.getTokenId());
    }

    @Test
    @DisplayName("shouldSetAndGetChannel")
    void shouldSetAndGetChannel() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setChannel("live");
        assertEquals("live", data.getChannel());
    }

    @Test
    @DisplayName("shouldSetAndGetIp")
    void shouldSetAndGetIp() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setIp("192.168.1.1");
        assertEquals("192.168.1.1", data.getIp());
    }

    @Test
    @DisplayName("shouldSetAndGetPhone")
    void shouldSetAndGetPhone() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setPhone("13800138000");
        assertEquals("13800138000", data.getPhone());
    }

    @Test
    @DisplayName("shouldSetAndGetDeviceId")
    void shouldSetAndGetDeviceId() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setDeviceId("dev-abc");
        assertEquals("dev-abc", data.getDeviceId());
    }

    @Test
    @DisplayName("shouldSetAndGetReceiveTokenId")
    void shouldSetAndGetReceiveTokenId() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setReceiveTokenId("recv-tok");
        assertEquals("recv-tok", data.getReceiveTokenId());
    }

    @Test
    @DisplayName("shouldSetAndGetLevel")
    void shouldSetAndGetLevel() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setLevel("VIP");
        assertEquals("VIP", data.getLevel());
    }

    @Test
    @DisplayName("shouldSetAndGetRegisterTime")
    void shouldSetAndGetRegisterTime() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setRegisterTime("2024-01-01");
        assertEquals("2024-01-01", data.getRegisterTime());
    }

    @Test
    @DisplayName("shouldSetAndGetFriendNum")
    void shouldSetAndGetFriendNum() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setFriendNum("100");
        assertEquals("100", data.getFriendNum());
    }

    @Test
    @DisplayName("shouldSetAndGetFansNum")
    void shouldSetAndGetFansNum() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setFansNum("5000");
        assertEquals("5000", data.getFansNum());
    }

    @Test
    @DisplayName("shouldSetAndGetRole")
    void shouldSetAndGetRole() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setRole("ADMIN");
        assertEquals("ADMIN", data.getRole());
    }

    @Test
    @DisplayName("shouldSetAndGetTopic")
    void shouldSetAndGetTopic() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setTopic("topic-42");
        assertEquals("topic-42", data.getTopic());
    }

    @Test
    @DisplayName("shouldSetAndGetIsPremiumUser")
    void shouldSetAndGetIsPremiumUser() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setIsPremiumUser(1);
        assertEquals(1, data.getIsPremiumUser());
    }

    @Test
    @DisplayName("shouldSupportRequestDataEqualsAndHashCode")
    void shouldSupportRequestDataEqualsAndHashCode() {
        AntiFraudRequestData a = new AntiFraudRequestData();
        a.setTokenId("tok");
        a.setIp("1.2.3.4");

        AntiFraudRequestData b = new AntiFraudRequestData();
        b.setTokenId("tok");
        b.setIp("1.2.3.4");

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportRequestDataInequality")
    void shouldSupportRequestDataInequality() {
        AntiFraudRequestData a = new AntiFraudRequestData();
        a.setTokenId("tok1");
        AntiFraudRequestData b = new AntiFraudRequestData();
        b.setTokenId("tok2");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceRequestDataToString")
    void shouldProduceRequestDataToString() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setTokenId("tok");
        String s = data.toString();
        assertTrue(s.contains("tokenId=tok"), "toString should contain tokenId");
    }
}
