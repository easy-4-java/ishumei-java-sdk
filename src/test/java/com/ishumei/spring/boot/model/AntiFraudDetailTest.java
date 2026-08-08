package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AntiFraudDetail}.
 */
@DisplayName("AntiFraudDetail")
class AntiFraudDetailTest {

    @Test
    @DisplayName("shouldCreateWithDefaults")
    void shouldCreateWithDefaults() {
        AntiFraudDetail d = new AntiFraudDetail();
        assertEquals(0, d.getRiskType());
        assertNull(d.getModel());
        assertNull(d.getDescription());
        assertNull(d.getDescriptionV2());
    }

    @Test
    @DisplayName("shouldSetAndGetRiskType")
    void shouldSetAndGetRiskType() {
        AntiFraudDetail d = new AntiFraudDetail();
        d.setRiskType(100);
        assertEquals(100, d.getRiskType());
    }

    @Test
    @DisplayName("shouldSetAndGetModel")
    void shouldSetAndGetModel() {
        AntiFraudDetail d = new AntiFraudDetail();
        d.setModel("strategy-1");
        assertEquals("strategy-1", d.getModel());
    }

    @Test
    @DisplayName("shouldSetAndGetDescription")
    void shouldSetAndGetDescription() {
        AntiFraudDetail d = new AntiFraudDetail();
        d.setDescription("politically sensitive");
        assertEquals("politically sensitive", d.getDescription());
    }

    @Test
    @DisplayName("shouldSetAndGetDescriptionV2")
    void shouldSetAndGetDescriptionV2() {
        AntiFraudDetail d = new AntiFraudDetail();
        d.setDescriptionV2("new description");
        assertEquals("new description", d.getDescriptionV2());
    }

    @Test
    @DisplayName("shouldSupportEqualsAndHashCode")
    void shouldSupportEqualsAndHashCode() {
        AntiFraudDetail a = new AntiFraudDetail();
        a.setRiskType(200);
        a.setModel("m1");

        AntiFraudDetail b = new AntiFraudDetail();
        b.setRiskType(200);
        b.setModel("m1");

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportInequality")
    void shouldSupportInequality() {
        AntiFraudDetail a = new AntiFraudDetail();
        a.setRiskType(100);
        AntiFraudDetail b = new AntiFraudDetail();
        b.setRiskType(200);
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceToString")
    void shouldProduceToString() {
        AntiFraudDetail d = new AntiFraudDetail();
        d.setRiskType(300);
        String s = d.toString();
        assertTrue(s.contains("riskType=300"));
    }
}
