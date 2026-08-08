package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for batch anti-fraud image models:
 * {@link BatchAntiFraudImageDetail}, {@link BatchAntiFraudImageDetailHits},
 * {@link BatchAntiFraudImageItem} and {@link BatchAntiFraudImageResponse}.
 */
@DisplayName("BatchAntiFraudImage models")
class BatchAntiFraudImageTest {

    // =====================================================================
    // BatchAntiFraudImageDetail
    // =====================================================================

    @Nested
    @DisplayName("BatchAntiFraudImageDetail")
    class DetailTests {

        @Test
        @DisplayName("shouldCreateWithDefaults")
        void shouldCreateWithDefaults() {
            BatchAntiFraudImageDetail d = new BatchAntiFraudImageDetail();
            assertNull(d.getDescription());
            assertNull(d.getDescriptionV2());
            assertNull(d.getText());
            assertNull(d.getPornLabel());
            assertEquals(0.0f, d.getPornRate(), 0.001f);
            assertEquals(0.0f, d.getSexyRate(), 0.001f);
            assertEquals(0.0f, d.getNormalRate(), 0.001f);
            assertNull(d.getPolityName());
            assertEquals(0.0f, d.getPolityRate(), 0.001f);
            assertNull(d.getViolenceLabel());
            assertEquals(0.0f, d.getRebelRate(), 0.001f);
            assertEquals(0.0f, d.getFlagRate(), 0.001f);
            assertEquals(0.0f, d.getArmyRate(), 0.001f);
            assertEquals(0.0f, d.getTerrorismRate(), 0.001f);
            assertEquals(0.0f, d.getWeaponRate(), 0.001f);
            assertEquals(0.0f, d.getBloodRate(), 0.001f);
            assertEquals(0.0f, d.getGameWeaponRate(), 0.001f);
            assertEquals(0.0f, d.getChinamapRate(), 0.001f);
            assertEquals(0.0f, d.getTankRate(), 0.001f);
            assertEquals(0.0f, d.getCandleRate(), 0.001f);
            assertEquals(0.0f, d.getUniformRate(), 0.001f);
            assertEquals(0.0f, d.getNonViolenceRate(), 0.001f);
            assertNull(d.getHits());
            assertNull(d.getModel());
            assertEquals(0, d.getRiskType());
            assertNull(d.getOriginalText());
            assertEquals(0, d.getSexyRiskTokenId());
            assertEquals(0, d.getTokenScore());
        }

        @Test
        @DisplayName("shouldSetAndGetAllStringFields")
        void shouldSetAndGetAllStringFields() {
            BatchAntiFraudImageDetail d = new BatchAntiFraudImageDetail();
            d.setDescription("desc");
            d.setDescriptionV2("desc2");
            d.setText("ocr");
            d.setPornLabel("色情");
            d.setPolityName("figure");
            d.setViolenceLabel("暴力");
            d.setModel("model");
            d.setOriginalText("orig");
            assertEquals("desc", d.getDescription());
            assertEquals("desc2", d.getDescriptionV2());
            assertEquals("ocr", d.getText());
            assertEquals("色情", d.getPornLabel());
            assertEquals("figure", d.getPolityName());
            assertEquals("暴力", d.getViolenceLabel());
            assertEquals("model", d.getModel());
            assertEquals("orig", d.getOriginalText());
        }

        @Test
        @DisplayName("shouldSetAndGetFloatRates")
        void shouldSetAndGetFloatRates() {
            BatchAntiFraudImageDetail d = new BatchAntiFraudImageDetail();
            d.setPornRate(0.8f);
            d.setSexyRate(0.7f);
            d.setNormalRate(0.1f);
            d.setPolityRate(0.2f);
            d.setRebelRate(0.01f);
            d.setFlagRate(0.02f);
            d.setArmyRate(0.03f);
            d.setTerrorismRate(0.04f);
            d.setWeaponRate(0.05f);
            d.setBloodRate(0.06f);
            d.setGameWeaponRate(0.07f);
            d.setChinamapRate(0.08f);
            d.setTankRate(0.09f);
            d.setCandleRate(0.11f);
            d.setUniformRate(0.12f);
            d.setNonViolenceRate(0.0f);
            assertEquals(0.8f, d.getPornRate(), 0.001f);
            assertEquals(0.7f, d.getSexyRate(), 0.001f);
            assertEquals(0.1f, d.getNormalRate(), 0.001f);
            assertEquals(0.2f, d.getPolityRate(), 0.001f);
            assertEquals(0.01f, d.getRebelRate(), 0.001f);
            assertEquals(0.02f, d.getFlagRate(), 0.001f);
            assertEquals(0.03f, d.getArmyRate(), 0.001f);
            assertEquals(0.04f, d.getTerrorismRate(), 0.001f);
            assertEquals(0.05f, d.getWeaponRate(), 0.001f);
            assertEquals(0.06f, d.getBloodRate(), 0.001f);
            assertEquals(0.07f, d.getGameWeaponRate(), 0.001f);
            assertEquals(0.08f, d.getChinamapRate(), 0.001f);
            assertEquals(0.09f, d.getTankRate(), 0.001f);
            assertEquals(0.11f, d.getCandleRate(), 0.001f);
            assertEquals(0.12f, d.getUniformRate(), 0.001f);
            assertEquals(0.0f, d.getNonViolenceRate(), 0.001f);
        }

        @Test
        @DisplayName("shouldSetAndGetIntFields")
        void shouldSetAndGetIntFields() {
            BatchAntiFraudImageDetail d = new BatchAntiFraudImageDetail();
            d.setRiskType(200);
            d.setSexyRiskTokenId(42);
            d.setTokenScore(800);
            assertEquals(200, d.getRiskType());
            assertEquals(42, d.getSexyRiskTokenId());
            assertEquals(800, d.getTokenScore());
        }

        @Test
        @DisplayName("shouldSetAndGetHits")
        void shouldSetAndGetHits() {
            BatchAntiFraudImageDetail d = new BatchAntiFraudImageDetail();
            BatchAntiFraudImageDetailHits hit = new BatchAntiFraudImageDetailHits();
            hit.setScore(500);
            d.setHits(List.of(hit));
            assertEquals(1, d.getHits().size());
            assertEquals(500, d.getHits().getFirst().getScore());
        }

        @Test
        @DisplayName("shouldSupportEqualsAndHashCode")
        void shouldSupportEqualsAndHashCode() {
            BatchAntiFraudImageDetail a = new BatchAntiFraudImageDetail();
            a.setRiskType(200);
            a.setTokenScore(800);
            BatchAntiFraudImageDetail b = new BatchAntiFraudImageDetail();
            b.setRiskType(200);
            b.setTokenScore(800);
            assertEquals(a, b);
            assertEquals(a.hashCode(), b.hashCode());
        }

        @Test
        @DisplayName("shouldSupportInequality")
        void shouldSupportInequality() {
            BatchAntiFraudImageDetail a = new BatchAntiFraudImageDetail();
            a.setRiskType(100);
            BatchAntiFraudImageDetail b = new BatchAntiFraudImageDetail();
            b.setRiskType(200);
            assertNotEquals(a, b);
        }

        @Test
        @DisplayName("shouldProduceToString")
        void shouldProduceToString() {
            BatchAntiFraudImageDetail d = new BatchAntiFraudImageDetail();
            d.setRiskType(300);
            d.setTokenScore(900);
            String s = d.toString();
            assertTrue(s.contains("riskType=300"));
            assertTrue(s.contains("tokenScore=900"));
        }
    }

    // =====================================================================
    // BatchAntiFraudImageDetailHits
    // =====================================================================

    @Nested
    @DisplayName("BatchAntiFraudImageDetailHits")
    class HitsTests {

        @Test
        @DisplayName("shouldCreateWithDefaults")
        void shouldCreateWithDefaults() {
            BatchAntiFraudImageDetailHits h = new BatchAntiFraudImageDetailHits();
            assertNull(h.getDescription());
            assertNull(h.getDescriptionV2());
            assertNull(h.getModel());
            assertNull(h.getRiskLevel());
            assertEquals(0, h.getRiskType());
            assertEquals(0, h.getScore());
        }

        @Test
        @DisplayName("shouldSetAndGetAllFields")
        void shouldSetAndGetAllFields() {
            BatchAntiFraudImageDetailHits h = new BatchAntiFraudImageDetailHits();
            h.setDescription("d1");
            h.setDescriptionV2("d2");
            h.setModel("m1");
            h.setRiskLevel("REJECT");
            h.setRiskType(200);
            h.setScore(750);
            assertEquals("d1", h.getDescription());
            assertEquals("d2", h.getDescriptionV2());
            assertEquals("m1", h.getModel());
            assertEquals("REJECT", h.getRiskLevel());
            assertEquals(200, h.getRiskType());
            assertEquals(750, h.getScore());
        }

        @Test
        @DisplayName("shouldSupportEqualsAndHashCode")
        void shouldSupportEqualsAndHashCode() {
            BatchAntiFraudImageDetailHits a = new BatchAntiFraudImageDetailHits();
            a.setScore(500);
            a.setRiskType(200);
            BatchAntiFraudImageDetailHits b = new BatchAntiFraudImageDetailHits();
            b.setScore(500);
            b.setRiskType(200);
            assertEquals(a, b);
            assertEquals(a.hashCode(), b.hashCode());
        }

        @Test
        @DisplayName("shouldSupportInequality")
        void shouldSupportInequality() {
            BatchAntiFraudImageDetailHits a = new BatchAntiFraudImageDetailHits();
            a.setScore(100);
            BatchAntiFraudImageDetailHits b = new BatchAntiFraudImageDetailHits();
            b.setScore(200);
            assertNotEquals(a, b);
        }

        @Test
        @DisplayName("shouldProduceToString")
        void shouldProduceToString() {
            BatchAntiFraudImageDetailHits h = new BatchAntiFraudImageDetailHits();
            h.setScore(500);
            h.setRiskLevel("PASS");
            String s = h.toString();
            assertTrue(s.contains("score=500"));
            assertTrue(s.contains("riskLevel=PASS"));
        }
    }

    // =====================================================================
    // BatchAntiFraudImageItem
    // =====================================================================

    @Nested
    @DisplayName("BatchAntiFraudImageItem")
    class ItemTests {

        private BatchAntiFraudImageItem build(String code, String riskLevel) {
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            item.setCode(code);
            item.setRiskLevel(riskLevel);
            return item;
        }

        @Test
        @DisplayName("shouldCreateWithDefaults")
        void shouldCreateWithDefaults() {
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            assertNull(item.getBtId());
            assertNull(item.getCode());
            assertNull(item.getDetail());
            assertNull(item.getMessage());
            assertNull(item.getRequestId());
            assertNull(item.getRiskLevel());
            assertEquals(0, item.getScore());
        }

        @Test
        @DisplayName("shouldSetAndGetBtId")
        void shouldSetAndGetBtId() {
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            item.setBtId("bt-1");
            assertEquals("bt-1", item.getBtId());
        }

        @Test
        @DisplayName("shouldSetAndGetCode")
        void shouldSetAndGetCode() {
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            item.setCode("1100");
            assertEquals("1100", item.getCode());
        }

        @Test
        @DisplayName("shouldSetAndGetDetail")
        void shouldSetAndGetDetail() {
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            BatchAntiFraudImageDetail detail = new BatchAntiFraudImageDetail();
            detail.setRiskType(200);
            item.setDetail(detail);
            assertNotNull(item.getDetail());
            assertEquals(200, item.getDetail().getRiskType());
        }

        @Test
        @DisplayName("shouldSetAndGetMessage")
        void shouldSetAndGetMessage() {
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            item.setMessage("ok");
            assertEquals("ok", item.getMessage());
        }

        @Test
        @DisplayName("shouldSetAndGetRequestId")
        void shouldSetAndGetRequestId() {
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            item.setRequestId("req-1");
            assertEquals("req-1", item.getRequestId());
        }

        @Test
        @DisplayName("shouldSetAndGetScore")
        void shouldSetAndGetScore() {
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            item.setScore(500);
            assertEquals(500, item.getScore());
        }

        // ── isPass / isReview / isReject ────────────────────────────────

        @Test
        @DisplayName("isPass shouldReturnTrueWhenCode1100AndPass")
        void isPass_shouldReturnTrueWhenCode1100AndPass() {
            assertTrue(build("1100", "PASS").isPass());
        }

        @Test
        @DisplayName("isPass shouldReturnFalseWhenReview")
        void isPass_shouldReturnFalseWhenReview() {
            assertFalse(build("1100", "REVIEW").isPass());
        }

        @Test
        @DisplayName("isPass shouldReturnFalseWhenCodeNot1100")
        void isPass_shouldReturnFalseWhenCodeNot1100() {
            assertFalse(build("1200", "PASS").isPass());
        }

        @Test
        @DisplayName("isReview shouldReturnTrueWhenCode1100AndReview")
        void isReview_shouldReturnTrueWhenCode1100AndReview() {
            assertTrue(build("1100", "REVIEW").isReview());
        }

        @Test
        @DisplayName("isReview shouldReturnFalseWhenPass")
        void isReview_shouldReturnFalseWhenPass() {
            assertFalse(build("1100", "PASS").isReview());
        }

        @Test
        @DisplayName("isReject shouldReturnTrueWhenCode1100AndReject")
        void isReject_shouldReturnTrueWhenCode1100AndReject() {
            assertTrue(build("1100", "REJECT").isReject());
        }

        @Test
        @DisplayName("isReject shouldReturnFalseWhenPass")
        void isReject_shouldReturnFalseWhenPass() {
            assertFalse(build("1100", "PASS").isReject());
        }

        @Test
        @DisplayName("shouldSupportEqualsAndHashCode")
        void shouldSupportEqualsAndHashCode() {
            BatchAntiFraudImageItem a = build("1100", "PASS");
            BatchAntiFraudImageItem b = build("1100", "PASS");
            assertEquals(a, b);
            assertEquals(a.hashCode(), b.hashCode());
        }

        @Test
        @DisplayName("shouldSupportInequality")
        void shouldSupportInequality() {
            BatchAntiFraudImageItem a = build("1100", "PASS");
            BatchAntiFraudImageItem b = build("1100", "REJECT");
            assertNotEquals(a, b);
        }

        @Test
        @DisplayName("shouldProduceToString")
        void shouldProduceToString() {
            BatchAntiFraudImageItem item = build("1100", "PASS");
            String s = item.toString();
            assertTrue(s.contains("code=1100"));
            assertTrue(s.contains("riskLevel=PASS"));
        }
    }

    // =====================================================================
    // BatchAntiFraudImageResponse
    // =====================================================================

    @Nested
    @DisplayName("BatchAntiFraudImageResponse")
    class ResponseTests {

        @Test
        @DisplayName("shouldCreateWithDefaults")
        void shouldCreateWithDefaults() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            assertNull(r.getCode());
            assertNull(r.getMessage());
            assertNull(r.getRequestId());
            assertNull(r.getImgs());
            assertNull(r.getStatistics());
        }

        @Test
        @DisplayName("shouldSetAndGetCode")
        void shouldSetAndGetCode() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            r.setCode("1100");
            assertEquals("1100", r.getCode());
        }

        @Test
        @DisplayName("shouldSetAndGetMessage")
        void shouldSetAndGetMessage() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            r.setMessage("ok");
            assertEquals("ok", r.getMessage());
        }

        @Test
        @DisplayName("shouldSetAndGetRequestId")
        void shouldSetAndGetRequestId() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            r.setRequestId("req-1");
            assertEquals("req-1", r.getRequestId());
        }

        @Test
        @DisplayName("shouldSetAndGetImgs")
        void shouldSetAndGetImgs() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
            item.setCode("1100");
            r.setImgs(List.of(item));
            assertEquals(1, r.getImgs().size());
        }

        @Test
        @DisplayName("shouldSetAndGetStatistics")
        void shouldSetAndGetStatistics() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            r.setStatistics(List.of(1, 2, 3, 4));
            assertEquals(4, r.getStatistics().size());
            assertEquals(1, r.getStatistics().get(0));
            assertEquals(4, r.getStatistics().get(3));
        }

        // ── isSuccess ───────────────────────────────────────────────────

        @Test
        @DisplayName("isSuccess shouldReturnTrueWhenCode1100")
        void isSuccess_shouldReturnTrueWhenCode1100() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            r.setCode("1100");
            assertTrue(r.isSuccess());
        }

        @Test
        @DisplayName("isSuccess shouldReturnFalseWhenCodeNot1100")
        void isSuccess_shouldReturnFalseWhenCodeNot1100() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            r.setCode("1200");
            assertFalse(r.isSuccess());
        }

        @Test
        @DisplayName("isSuccess shouldReturnFalseWhenCodeNull")
        void isSuccess_shouldReturnFalseWhenCodeNull() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            assertFalse(r.isSuccess());
        }

        @Test
        @DisplayName("shouldSupportEqualsAndHashCode")
        void shouldSupportEqualsAndHashCode() {
            BatchAntiFraudImageResponse a = new BatchAntiFraudImageResponse();
            a.setCode("1100");
            a.setRequestId("r1");
            BatchAntiFraudImageResponse b = new BatchAntiFraudImageResponse();
            b.setCode("1100");
            b.setRequestId("r1");
            assertEquals(a, b);
            assertEquals(a.hashCode(), b.hashCode());
        }

        @Test
        @DisplayName("shouldSupportInequality")
        void shouldSupportInequality() {
            BatchAntiFraudImageResponse a = new BatchAntiFraudImageResponse();
            a.setCode("1100");
            BatchAntiFraudImageResponse b = new BatchAntiFraudImageResponse();
            b.setCode("1200");
            assertNotEquals(a, b);
        }

        @Test
        @DisplayName("shouldProduceToString")
        void shouldProduceToString() {
            BatchAntiFraudImageResponse r = new BatchAntiFraudImageResponse();
            r.setCode("1100");
            r.setMessage("ok");
            String s = r.toString();
            assertTrue(s.contains("code=1100"));
            assertTrue(s.contains("message=ok"));
        }
    }
}
