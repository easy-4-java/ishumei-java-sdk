package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AntiFraudImageRequest}, {@link AntiFraudImageRequestData}
 * and {@link AntiFraudImageRequestItem}.
 */
@DisplayName("AntiFraudImageRequest models")
class AntiFraudImageRequestTest {

    // ── AntiFraudImageRequest ───────────────────────────────────────────

    @Test
    @DisplayName("shouldInheritDefaultAppId")
    void shouldInheritDefaultAppId() {
        AntiFraudImageRequest req = new AntiFraudImageRequest();
        assertEquals("default", req.getAppId());
    }

    @Test
    @DisplayName("shouldSetAndGetData")
    void shouldSetAndGetData() {
        AntiFraudImageRequest req = new AntiFraudImageRequest();
        AntiFraudImageRequestData data = new AntiFraudImageRequestData();
        data.setImg("base64...");
        req.setData(data);
        assertNotNull(req.getData());
        assertEquals("base64...", req.getData().getImg());
    }

    @Test
    @DisplayName("shouldHaveNullDataByDefault")
    void shouldHaveNullDataByDefault() {
        AntiFraudImageRequest req = new AntiFraudImageRequest();
        assertNull(req.getData());
    }

    @Test
    @DisplayName("shouldSupportEquals")
    void shouldSupportImageRequestEquals() {
        AntiFraudImageRequest a = new AntiFraudImageRequest();
        a.setAccessKey("k");
        AntiFraudImageRequest b = new AntiFraudImageRequest();
        b.setAccessKey("k");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportInequality")
    void shouldSupportImageRequestInequality() {
        AntiFraudImageRequest a = new AntiFraudImageRequest();
        a.setAccessKey("k1");
        AntiFraudImageRequest b = new AntiFraudImageRequest();
        b.setAccessKey("k2");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceToString")
    void shouldProduceImageRequestToString() {
        AntiFraudImageRequest req = new AntiFraudImageRequest();
        AntiFraudImageRequestData data = new AntiFraudImageRequestData();
        data.setImg("pic");
        req.setData(data);
        String s = req.toString();
        assertTrue(s.contains("AntiFraudImageRequest"));
        assertTrue(s.contains("data="));
    }

    // ── AntiFraudImageRequestData ───────────────────────────────────────

    @Test
    @DisplayName("shouldCreateImageDataWithDefaults")
    void shouldCreateImageDataWithDefaults() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        assertNull(d.getImg());
        assertNull(d.getImgs());
        assertNull(d.getBtId());
        assertEquals(0, d.getSex());
        assertEquals(0, d.getAge());
        assertNull(d.getImei());
        assertNull(d.getMac());
        assertNull(d.getIdfv());
        assertNull(d.getIdfa());
        assertEquals(20, d.getMaxFrame());
        assertEquals(1, d.getInterval());
    }

    @Test
    @DisplayName("shouldInheritRequestDataDefaults")
    void shouldInheritRequestDataDefaults() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        assertEquals("USER", d.getRole());
        assertEquals(0, d.getIsPremiumUser());
    }

    @Test
    @DisplayName("shouldSetAndGetImg")
    void shouldSetAndGetImg() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setImg("http://example.com/img.jpg");
        assertEquals("http://example.com/img.jpg", d.getImg());
    }

    @Test
    @DisplayName("shouldSetAndGetImgs")
    void shouldSetAndGetImgs() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
        item.setImg("base64...");
        d.setImgs(List.of(item));
        assertEquals(1, d.getImgs().size());
    }

    @Test
    @DisplayName("shouldSetAndGetBtId")
    void shouldSetAndGetBtId() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setBtId("bt-123");
        assertEquals("bt-123", d.getBtId());
    }

    @Test
    @DisplayName("shouldSetAndGetSex")
    void shouldSetAndGetSex() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setSex(1);
        assertEquals(1, d.getSex());
    }

    @Test
    @DisplayName("shouldSetAndGetAge")
    void shouldSetAndGetAge() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setAge(2);
        assertEquals(2, d.getAge());
    }

    @Test
    @DisplayName("shouldSetAndGetImei")
    void shouldSetAndGetImei() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setImei("imei-123");
        assertEquals("imei-123", d.getImei());
    }

    @Test
    @DisplayName("shouldSetAndGetMac")
    void shouldSetAndGetMac() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setMac("AA:BB:CC:DD:EE:FF");
        assertEquals("AA:BB:CC:DD:EE:FF", d.getMac());
    }

    @Test
    @DisplayName("shouldSetAndGetIdfv")
    void shouldSetAndGetIdfv() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setIdfv("idfv-1");
        assertEquals("idfv-1", d.getIdfv());
    }

    @Test
    @DisplayName("shouldSetAndGetIdfa")
    void shouldSetAndGetIdfa() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setIdfa("idfa-1");
        assertEquals("idfa-1", d.getIdfa());
    }

    @Test
    @DisplayName("shouldSetAndGetMaxFrame")
    void shouldSetAndGetMaxFrame() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setMaxFrame(50);
        assertEquals(50, d.getMaxFrame());
    }

    @Test
    @DisplayName("shouldSetAndGetInterval")
    void shouldSetAndGetInterval() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setInterval(5);
        assertEquals(5, d.getInterval());
    }

    @Test
    @DisplayName("shouldSetInheritedFields")
    void shouldSetInheritedFields() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setTokenId("tok");
        d.setIp("2.2.2.2");
        assertEquals("tok", d.getTokenId());
        assertEquals("2.2.2.2", d.getIp());
    }

    @Test
    @DisplayName("shouldSupportImageDataEquals")
    void shouldSupportImageDataEquals() {
        AntiFraudImageRequestData a = new AntiFraudImageRequestData();
        a.setImg("img1");
        AntiFraudImageRequestData b = new AntiFraudImageRequestData();
        b.setImg("img1");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportImageDataInequality")
    void shouldSupportImageDataInequality() {
        AntiFraudImageRequestData a = new AntiFraudImageRequestData();
        a.setImg("img1");
        AntiFraudImageRequestData b = new AntiFraudImageRequestData();
        b.setImg("img2");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceImageDataToString")
    void shouldProduceImageDataToString() {
        AntiFraudImageRequestData d = new AntiFraudImageRequestData();
        d.setImg("pic");
        String s = d.toString();
        assertTrue(s.contains("img=pic"));
    }

    // ── AntiFraudImageRequestItem ───────────────────────────────────────

    @Test
    @DisplayName("shouldCreateImageRequestItemWithDefaults")
    void shouldCreateImageRequestItemWithDefaults() {
        AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
        assertNull(item.getImg());
        assertNull(item.getTokenId());
        assertNull(item.getBtId());
    }

    @Test
    @DisplayName("shouldSetAndGetItemImg")
    void shouldSetAndGetItemImg() {
        AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
        item.setImg("base64...");
        assertEquals("base64...", item.getImg());
    }

    @Test
    @DisplayName("shouldSetAndGetItemTokenId")
    void shouldSetAndGetItemTokenId() {
        AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
        item.setTokenId("tok-1");
        assertEquals("tok-1", item.getTokenId());
    }

    @Test
    @DisplayName("shouldSetAndGetItemBtId")
    void shouldSetAndGetItemBtId() {
        AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
        item.setBtId("bt-1");
        assertEquals("bt-1", item.getBtId());
    }

    @Test
    @DisplayName("shouldSupportItemEquals")
    void shouldSupportItemEquals() {
        AntiFraudImageRequestItem a = new AntiFraudImageRequestItem();
        a.setImg("img");
        AntiFraudImageRequestItem b = new AntiFraudImageRequestItem();
        b.setImg("img");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportItemInequality")
    void shouldSupportItemInequality() {
        AntiFraudImageRequestItem a = new AntiFraudImageRequestItem();
        a.setImg("a");
        AntiFraudImageRequestItem b = new AntiFraudImageRequestItem();
        b.setImg("b");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceItemToString")
    void shouldProduceItemToString() {
        AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
        item.setImg("pic");
        item.setTokenId("tok");
        String s = item.toString();
        assertTrue(s.contains("img=pic"));
        assertTrue(s.contains("tokenId=tok"));
    }
}
