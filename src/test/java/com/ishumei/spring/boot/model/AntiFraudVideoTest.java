package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AntiFraudVideoRequest}, {@link AntiFraudVideoRequestData}
 * and {@link AntiFraudVideoResponse}.
 */
@DisplayName("AntiFraudVideo models")
class AntiFraudVideoTest {

    // ── AntiFraudVideoRequest ───────────────────────────────────────────

    @Test
    @DisplayName("shouldInheritDefaultAppId")
    void shouldInheritDefaultAppId() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        assertEquals("default", req.getAppId());
    }

    @Test
    @DisplayName("shouldSetAndGetImgType")
    void shouldSetAndGetImgType() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        req.setImgType("img-type");
        assertEquals("img-type", req.getImgType());
    }

    @Test
    @DisplayName("shouldSetAndGetAudioType")
    void shouldSetAndGetAudioType() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        req.setAudioType("audio-type");
        assertEquals("audio-type", req.getAudioType());
    }

    @Test
    @DisplayName("shouldSetAndGetSubtitleType")
    void shouldSetAndGetSubtitleType() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        req.setSubtitleType("sub-type");
        assertEquals("sub-type", req.getSubtitleType());
    }

    @Test
    @DisplayName("shouldSetAndGetBtId")
    void shouldSetAndGetBtId() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        req.setBtId("bt-1");
        assertEquals("bt-1", req.getBtId());
    }

    @Test
    @DisplayName("shouldSetAndGetData")
    void shouldSetAndGetData() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        AntiFraudVideoRequestData data = new AntiFraudVideoRequestData();
        data.setUrl("http://example.com/video.mp4");
        req.setData(data);
        assertNotNull(req.getData());
        assertEquals("http://example.com/video.mp4", req.getData().getUrl());
    }

    @Test
    @DisplayName("shouldHaveNullDataByDefault")
    void shouldHaveNullDataByDefault() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        assertNull(req.getData());
    }

    @Test
    @DisplayName("shouldHaveNullMediaTypesByDefault")
    void shouldHaveNullMediaTypesByDefault() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        assertNull(req.getImgType());
        assertNull(req.getAudioType());
        assertNull(req.getSubtitleType());
        assertNull(req.getBtId());
    }

    @Test
    @DisplayName("shouldSupportEquals")
    void shouldSupportVideoRequestEquals() {
        AntiFraudVideoRequest a = new AntiFraudVideoRequest();
        a.setAccessKey("k");
        AntiFraudVideoRequest b = new AntiFraudVideoRequest();
        b.setAccessKey("k");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportInequality")
    void shouldSupportVideoRequestInequality() {
        AntiFraudVideoRequest a = new AntiFraudVideoRequest();
        a.setAccessKey("k1");
        AntiFraudVideoRequest b = new AntiFraudVideoRequest();
        b.setAccessKey("k2");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceToString")
    void shouldProduceVideoRequestToString() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        AntiFraudVideoRequestData data = new AntiFraudVideoRequestData();
        data.setUrl("http://example.com/v.mp4");
        req.setData(data);
        String s = req.toString();
        assertTrue(s.contains("AntiFraudVideoRequest"));
        assertTrue(s.contains("data="));
    }

    // ── AntiFraudVideoRequestData ───────────────────────────────────────

    @Test
    @DisplayName("shouldCreateVideoDataWithDefaults")
    void shouldCreateVideoDataWithDefaults() {
        AntiFraudVideoRequestData d = new AntiFraudVideoRequestData();
        assertNull(d.getUrl());
    }

    @Test
    @DisplayName("shouldInheritRequestDataDefaults")
    void shouldInheritRequestDataDefaults() {
        AntiFraudVideoRequestData d = new AntiFraudVideoRequestData();
        assertEquals("USER", d.getRole());
        assertEquals(0, d.getIsPremiumUser());
    }

    @Test
    @DisplayName("shouldSetAndGetUrl")
    void shouldSetAndGetUrl() {
        AntiFraudVideoRequestData d = new AntiFraudVideoRequestData();
        d.setUrl("http://example.com/video.mp4");
        assertEquals("http://example.com/video.mp4", d.getUrl());
    }

    @Test
    @DisplayName("shouldSetInheritedFields")
    void shouldSetInheritedFields() {
        AntiFraudVideoRequestData d = new AntiFraudVideoRequestData();
        d.setTokenId("tok");
        d.setIp("3.3.3.3");
        d.setDeviceId("dev-1");
        assertEquals("tok", d.getTokenId());
        assertEquals("3.3.3.3", d.getIp());
        assertEquals("dev-1", d.getDeviceId());
    }

    @Test
    @DisplayName("shouldSupportVideoDataEquals")
    void shouldSupportVideoDataEquals() {
        AntiFraudVideoRequestData a = new AntiFraudVideoRequestData();
        a.setUrl("u1");
        AntiFraudVideoRequestData b = new AntiFraudVideoRequestData();
        b.setUrl("u1");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportVideoDataInequality")
    void shouldSupportVideoDataInequality() {
        AntiFraudVideoRequestData a = new AntiFraudVideoRequestData();
        a.setUrl("u1");
        AntiFraudVideoRequestData b = new AntiFraudVideoRequestData();
        b.setUrl("u2");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceVideoDataToString")
    void shouldProduceVideoDataToString() {
        AntiFraudVideoRequestData d = new AntiFraudVideoRequestData();
        d.setUrl("http://example.com/v.mp4");
        String s = d.toString();
        assertTrue(s.contains("url=http://example.com/v.mp4"));
    }

    // ── AntiFraudVideoResponse ──────────────────────────────────────────

    @Test
    @DisplayName("shouldCreateVideoResponseWithDefaults")
    void shouldCreateVideoResponseWithDefaults() {
        AntiFraudVideoResponse r = new AntiFraudVideoResponse();
        assertNull(r.getCode());
        assertNull(r.getMessage());
        assertNull(r.getRequestId());
    }

    @Test
    @DisplayName("shouldSetAndGetVideoResponseCode")
    void shouldSetAndGetVideoResponseCode() {
        AntiFraudVideoResponse r = new AntiFraudVideoResponse();
        r.setCode("1100");
        assertEquals("1100", r.getCode());
    }

    @Test
    @DisplayName("shouldSetAndGetVideoResponseMessage")
    void shouldSetAndGetVideoResponseMessage() {
        AntiFraudVideoResponse r = new AntiFraudVideoResponse();
        r.setMessage("success");
        assertEquals("success", r.getMessage());
    }

    @Test
    @DisplayName("shouldSetAndGetVideoResponseRequestId")
    void shouldSetAndGetVideoResponseRequestId() {
        AntiFraudVideoResponse r = new AntiFraudVideoResponse();
        r.setRequestId("req-abc");
        assertEquals("req-abc", r.getRequestId());
    }

    @Test
    @DisplayName("shouldSupportVideoResponseEquals")
    void shouldSupportVideoResponseEquals() {
        AntiFraudVideoResponse a = new AntiFraudVideoResponse();
        a.setCode("1100");
        a.setRequestId("r1");
        AntiFraudVideoResponse b = new AntiFraudVideoResponse();
        b.setCode("1100");
        b.setRequestId("r1");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportVideoResponseInequality")
    void shouldSupportVideoResponseInequality() {
        AntiFraudVideoResponse a = new AntiFraudVideoResponse();
        a.setCode("1100");
        AntiFraudVideoResponse b = new AntiFraudVideoResponse();
        b.setCode("1200");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceVideoResponseToString")
    void shouldProduceVideoResponseToString() {
        AntiFraudVideoResponse r = new AntiFraudVideoResponse();
        r.setCode("1100");
        r.setMessage("ok");
        String s = r.toString();
        assertTrue(s.contains("code=1100"));
        assertTrue(s.contains("message=ok"));
    }
}
