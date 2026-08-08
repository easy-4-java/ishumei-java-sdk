package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AntiFraudImageDetail} and {@link AntiFraudImageDetailHits}.
 */
@DisplayName("AntiFraudImageDetail / AntiFraudImageDetailHits")
class AntiFraudImageDetailTest {

    // ── AntiFraudImageDetail ────────────────────────────────────────────

    @Test
    @DisplayName("shouldCreateImageDetailWithDefaults")
    void shouldCreateImageDetailWithDefaults() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
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
        assertEquals(0, d.getRiskSource());
    }

    @Test
    @DisplayName("shouldSetAndGetDescription")
    void shouldSetAndGetDescription() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setDescription("porn");
        assertEquals("porn", d.getDescription());
    }

    @Test
    @DisplayName("shouldSetAndGetDescriptionV2")
    void shouldSetAndGetDescriptionV2() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setDescriptionV2("new desc");
        assertEquals("new desc", d.getDescriptionV2());
    }

    @Test
    @DisplayName("shouldSetAndGetText")
    void shouldSetAndGetText() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setText("ocr text");
        assertEquals("ocr text", d.getText());
    }

    @Test
    @DisplayName("shouldSetAndGetPornLabel")
    void shouldSetAndGetPornLabel() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setPornLabel("色情");
        assertEquals("色情", d.getPornLabel());
    }

    @Test
    @DisplayName("shouldSetAndGetProbabilityRates")
    void shouldSetAndGetProbabilityRates() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setPornRate(0.9f);
        d.setSexyRate(0.1f);
        d.setNormalRate(0.0f);
        d.setPolityRate(0.3f);
        d.setRebelRate(0.05f);
        d.setFlagRate(0.02f);
        d.setArmyRate(0.01f);
        d.setTerrorismRate(0.03f);
        d.setWeaponRate(0.07f);
        d.setBloodRate(0.04f);
        d.setGameWeaponRate(0.06f);
        d.setChinamapRate(0.08f);
        d.setTankRate(0.09f);
        d.setCandleRate(0.11f);
        d.setUniformRate(0.12f);
        d.setNonViolenceRate(0.00f);
        assertEquals(0.9f, d.getPornRate(), 0.001f);
        assertEquals(0.1f, d.getSexyRate(), 0.001f);
        assertEquals(0.0f, d.getNormalRate(), 0.001f);
        assertEquals(0.3f, d.getPolityRate(), 0.001f);
        assertEquals(0.05f, d.getRebelRate(), 0.001f);
        assertEquals(0.02f, d.getFlagRate(), 0.001f);
        assertEquals(0.01f, d.getArmyRate(), 0.001f);
        assertEquals(0.03f, d.getTerrorismRate(), 0.001f);
        assertEquals(0.07f, d.getWeaponRate(), 0.001f);
        assertEquals(0.04f, d.getBloodRate(), 0.001f);
        assertEquals(0.06f, d.getGameWeaponRate(), 0.001f);
        assertEquals(0.08f, d.getChinamapRate(), 0.001f);
        assertEquals(0.09f, d.getTankRate(), 0.001f);
        assertEquals(0.11f, d.getCandleRate(), 0.001f);
        assertEquals(0.12f, d.getUniformRate(), 0.001f);
        assertEquals(0.00f, d.getNonViolenceRate(), 0.001f);
    }

    @Test
    @DisplayName("shouldSetAndGetPolityName")
    void shouldSetAndGetPolityName() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setPolityName("figure-x");
        assertEquals("figure-x", d.getPolityName());
    }

    @Test
    @DisplayName("shouldSetAndGetViolenceLabel")
    void shouldSetAndGetViolenceLabel() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setViolenceLabel("枪支刀具");
        assertEquals("枪支刀具", d.getViolenceLabel());
    }

    @Test
    @DisplayName("shouldSetAndGetHits")
    void shouldSetAndGetHits() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        AntiFraudImageDetailHits hit = new AntiFraudImageDetailHits();
        hit.setScore(500);
        d.setHits(List.of(hit));
        assertEquals(1, d.getHits().size());
        assertEquals(500, d.getHits().get(0).getScore());
    }

    @Test
    @DisplayName("shouldSetAndGetModel")
    void shouldSetAndGetModel() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setModel("model-1");
        assertEquals("model-1", d.getModel());
    }

    @Test
    @DisplayName("shouldSetAndGetRiskType")
    void shouldSetAndGetRiskType() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setRiskType(200);
        assertEquals(200, d.getRiskType());
    }

    @Test
    @DisplayName("shouldSetAndGetOriginalText")
    void shouldSetAndGetOriginalText() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setOriginalText("original");
        assertEquals("original", d.getOriginalText());
    }

    @Test
    @DisplayName("shouldSetAndGetSexyRiskTokenId")
    void shouldSetAndGetSexyRiskTokenId() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setSexyRiskTokenId(42);
        assertEquals(42, d.getSexyRiskTokenId());
    }

    @Test
    @DisplayName("shouldSetAndGetRiskSource")
    void shouldSetAndGetRiskSource() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setRiskSource(3);
        assertEquals(3, d.getRiskSource());
    }

    @Test
    @DisplayName("shouldSupportEqualsAndHashCode")
    void shouldSupportEqualsAndHashCode() {
        AntiFraudImageDetail a = new AntiFraudImageDetail();
        a.setRiskType(200);
        a.setPornRate(0.9f);
        AntiFraudImageDetail b = new AntiFraudImageDetail();
        b.setRiskType(200);
        b.setPornRate(0.9f);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportInequality")
    void shouldSupportInequality() {
        AntiFraudImageDetail a = new AntiFraudImageDetail();
        a.setRiskType(100);
        AntiFraudImageDetail b = new AntiFraudImageDetail();
        b.setRiskType(200);
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceToString")
    void shouldProduceToString() {
        AntiFraudImageDetail d = new AntiFraudImageDetail();
        d.setRiskType(300);
        String s = d.toString();
        assertTrue(s.contains("riskType=300"));
    }

    // ── AntiFraudImageDetailHits ────────────────────────────────────────

    @Test
    @DisplayName("shouldCreateHitsWithDefaults")
    void shouldCreateHitsWithDefaults() {
        AntiFraudImageDetailHits h = new AntiFraudImageDetailHits();
        assertNull(h.getDescription());
        assertNull(h.getDescriptionV2());
        assertNull(h.getModel());
        assertNull(h.getRiskLevel());
        assertEquals(0, h.getRiskType());
        assertEquals(0, h.getScore());
    }

    @Test
    @DisplayName("shouldSetAndGetHitsDescription")
    void shouldSetAndGetHitsDescription() {
        AntiFraudImageDetailHits h = new AntiFraudImageDetailHits();
        h.setDescription("porn detected");
        assertEquals("porn detected", h.getDescription());
    }

    @Test
    @DisplayName("shouldSetAndGetHitsDescriptionV2")
    void shouldSetAndGetHitsDescriptionV2() {
        AntiFraudImageDetailHits h = new AntiFraudImageDetailHits();
        h.setDescriptionV2("v2 desc");
        assertEquals("v2 desc", h.getDescriptionV2());
    }

    @Test
    @DisplayName("shouldSetAndGetHitsModel")
    void shouldSetAndGetHitsModel() {
        AntiFraudImageDetailHits h = new AntiFraudImageDetailHits();
        h.setModel("strategy-2");
        assertEquals("strategy-2", h.getModel());
    }

    @Test
    @DisplayName("shouldSetAndGetHitsRiskLevel")
    void shouldSetAndGetHitsRiskLevel() {
        AntiFraudImageDetailHits h = new AntiFraudImageDetailHits();
        h.setRiskLevel("REJECT");
        assertEquals("REJECT", h.getRiskLevel());
    }

    @Test
    @DisplayName("shouldSetAndGetHitsRiskType")
    void shouldSetAndGetHitsRiskType() {
        AntiFraudImageDetailHits h = new AntiFraudImageDetailHits();
        h.setRiskType(200);
        assertEquals(200, h.getRiskType());
    }

    @Test
    @DisplayName("shouldSetAndGetHitsScore")
    void shouldSetAndGetHitsScore() {
        AntiFraudImageDetailHits h = new AntiFraudImageDetailHits();
        h.setScore(750);
        assertEquals(750, h.getScore());
    }

    @Test
    @DisplayName("shouldSupportHitsEquals")
    void shouldSupportHitsEquals() {
        AntiFraudImageDetailHits a = new AntiFraudImageDetailHits();
        a.setScore(500);
        a.setRiskType(200);
        AntiFraudImageDetailHits b = new AntiFraudImageDetailHits();
        b.setScore(500);
        b.setRiskType(200);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportHitsInequality")
    void shouldSupportHitsInequality() {
        AntiFraudImageDetailHits a = new AntiFraudImageDetailHits();
        a.setScore(100);
        AntiFraudImageDetailHits b = new AntiFraudImageDetailHits();
        b.setScore(200);
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceHitsToString")
    void shouldProduceHitsToString() {
        AntiFraudImageDetailHits h = new AntiFraudImageDetailHits();
        h.setScore(500);
        String s = h.toString();
        assertTrue(s.contains("score=500"));
    }
}
