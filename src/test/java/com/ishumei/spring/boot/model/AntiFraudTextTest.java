package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AntiFraudTextRequest}, {@link AntiFraudTextRequestData}
 * and {@link AntiFraudTextWordPostitionsDetail}.
 */
@DisplayName("AntiFraudText models")
class AntiFraudTextTest {

    // ── AntiFraudTextRequest ────────────────────────────────────────────

    @Test
    @DisplayName("shouldInheritDefaultAppIdFromParent")
    void shouldInheritDefaultAppIdFromParent() {
        AntiFraudTextRequest req = new AntiFraudTextRequest();
        assertEquals("default", req.getAppId());
    }

    @Test
    @DisplayName("shouldSetAndGetData")
    void shouldSetAndGetData() {
        AntiFraudTextRequest req = new AntiFraudTextRequest();
        AntiFraudTextRequestData data = new AntiFraudTextRequestData();
        data.setText("hello");
        req.setData(data);
        assertNotNull(req.getData());
        assertEquals("hello", req.getData().getText());
    }

    @Test
    @DisplayName("shouldHaveNullDataByDefault")
    void shouldHaveNullDataByDefault() {
        AntiFraudTextRequest req = new AntiFraudTextRequest();
        assertNull(req.getData());
    }

    @Test
    @DisplayName("shouldSupportEqualsAndHashCode")
    void shouldSupportTextRequestEquals() {
        AntiFraudTextRequest a = new AntiFraudTextRequest();
        a.setAccessKey("k");
        AntiFraudTextRequest b = new AntiFraudTextRequest();
        b.setAccessKey("k");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportInequality")
    void shouldSupportTextRequestInequality() {
        AntiFraudTextRequest a = new AntiFraudTextRequest();
        a.setAccessKey("k1");
        AntiFraudTextRequest b = new AntiFraudTextRequest();
        b.setAccessKey("k2");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceToString")
    void shouldProduceTextRequestToString() {
        AntiFraudTextRequest req = new AntiFraudTextRequest();
        AntiFraudTextRequestData data = new AntiFraudTextRequestData();
        data.setText("hello");
        req.setData(data);
        String s = req.toString();
        assertTrue(s.contains("AntiFraudTextRequest"));
        assertTrue(s.contains("data="));
    }

    // ── AntiFraudTextRequestData ────────────────────────────────────────

    @Test
    @DisplayName("shouldCreateTextRequestDataWithDefaults")
    void shouldCreateTextRequestDataWithDefaults() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        assertNull(d.getText());
        assertEquals(0, d.getGender());
        assertNull(d.getNickname());
        assertNull(d.getRoom());
        assertEquals(0, d.getIsTokenSeperate());
    }

    @Test
    @DisplayName("shouldInheritRequestDataDefaults")
    void shouldInheritRequestDataDefaults() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        assertEquals("USER", d.getRole());
        assertEquals(0, d.getIsPremiumUser());
    }

    @Test
    @DisplayName("shouldSetAndGetText")
    void shouldSetAndGetText() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        d.setText("some text");
        assertEquals("some text", d.getText());
    }

    @Test
    @DisplayName("shouldSetAndGetGender")
    void shouldSetAndGetGender() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        d.setGender(1);
        assertEquals(1, d.getGender());
    }

    @Test
    @DisplayName("shouldSetAndGetNickname")
    void shouldSetAndGetNickname() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        d.setNickname("nick");
        assertEquals("nick", d.getNickname());
    }

    @Test
    @DisplayName("shouldSetAndGetRoom")
    void shouldSetAndGetRoom() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        d.setRoom("room-1");
        assertEquals("room-1", d.getRoom());
    }

    @Test
    @DisplayName("shouldSetAndGetIsTokenSeperate")
    void shouldSetAndGetIsTokenSeperate() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        d.setIsTokenSeperate(1);
        assertEquals(1, d.getIsTokenSeperate());
    }

    @Test
    @DisplayName("shouldSetInheritedFields")
    void shouldSetInheritedFields() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        d.setTokenId("tok");
        d.setIp("1.1.1.1");
        assertEquals("tok", d.getTokenId());
        assertEquals("1.1.1.1", d.getIp());
    }

    @Test
    @DisplayName("shouldSupportTextDataEquals")
    void shouldSupportTextDataEquals() {
        AntiFraudTextRequestData a = new AntiFraudTextRequestData();
        a.setText("x");
        AntiFraudTextRequestData b = new AntiFraudTextRequestData();
        b.setText("x");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportTextDataInequality")
    void shouldSupportTextDataInequality() {
        AntiFraudTextRequestData a = new AntiFraudTextRequestData();
        a.setText("x");
        AntiFraudTextRequestData b = new AntiFraudTextRequestData();
        b.setText("y");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceTextDataToString")
    void shouldProduceTextDataToString() {
        AntiFraudTextRequestData d = new AntiFraudTextRequestData();
        d.setText("hello");
        String s = d.toString();
        assertTrue(s.contains("text=hello"));
    }

    // ── AntiFraudTextWordPostitionsDetail ───────────────────────────────

    @Test
    @DisplayName("shouldCreateWordPositionsWithDefaults")
    void shouldCreateWordPositionsWithDefaults() {
        AntiFraudTextWordPostitionsDetail d = new AntiFraudTextWordPostitionsDetail();
        assertNull(d.getWord());
        assertNull(d.getPosition());
    }

    @Test
    @DisplayName("shouldSetAndGetWord")
    void shouldSetAndGetWord() {
        AntiFraudTextWordPostitionsDetail d = new AntiFraudTextWordPostitionsDetail();
        d.setWord("bad-word");
        assertEquals("bad-word", d.getWord());
    }

    @Test
    @DisplayName("shouldSetAndGetPosition")
    void shouldSetAndGetPosition() {
        AntiFraudTextWordPostitionsDetail d = new AntiFraudTextWordPostitionsDetail();
        d.setPosition("0-4");
        assertEquals("0-4", d.getPosition());
    }

    @Test
    @DisplayName("shouldSupportWordPositionsEquals")
    void shouldSupportWordPositionsEquals() {
        AntiFraudTextWordPostitionsDetail a = new AntiFraudTextWordPostitionsDetail();
        a.setWord("w");
        a.setPosition("0-4");
        AntiFraudTextWordPostitionsDetail b = new AntiFraudTextWordPostitionsDetail();
        b.setWord("w");
        b.setPosition("0-4");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportWordPositionsInequality")
    void shouldSupportWordPositionsInequality() {
        AntiFraudTextWordPostitionsDetail a = new AntiFraudTextWordPostitionsDetail();
        a.setWord("a");
        AntiFraudTextWordPostitionsDetail b = new AntiFraudTextWordPostitionsDetail();
        b.setWord("b");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceWordPositionsToString")
    void shouldProduceWordPositionsToString() {
        AntiFraudTextWordPostitionsDetail d = new AntiFraudTextWordPostitionsDetail();
        d.setWord("term");
        d.setPosition("5-9");
        String s = d.toString();
        assertTrue(s.contains("word=term"));
        assertTrue(s.contains("position=5-9"));
    }
}
