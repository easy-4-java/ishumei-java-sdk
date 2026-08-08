package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AntiFraudImageResponse}.
 */
@DisplayName("AntiFraudImageResponse")
class AntiFraudImageResponseTest {

    private AntiFraudImageResponse build(String code, int status, String riskLevel) {
        AntiFraudImageResponse r = new AntiFraudImageResponse();
        r.setCode(code);
        r.setStatus(status);
        r.setRiskLevel(riskLevel);
        return r;
    }

    // ── field defaults ──────────────────────────────────────────────────

    @Test
    @DisplayName("shouldCreateWithDefaults")
    void shouldCreateWithDefaults() {
        AntiFraudImageResponse r = new AntiFraudImageResponse();
        assertNull(r.getCode());
        assertNull(r.getMessage());
        assertNull(r.getRequestId());
        assertEquals(0, r.getScore());
        assertNull(r.getRiskLevel());
        assertEquals(0, r.getStatus());
        assertNull(r.getTaskId());
        assertNull(r.getDetail());
    }

    // ── isSuccess ───────────────────────────────────────────────────────

    @Nested
    @DisplayName("isSuccess")
    class IsSuccess {

        @Test
        @DisplayName("shouldReturnTrueWhenStatusZeroAndCode1100")
        void shouldReturnTrueWhenStatusZeroAndCode1100() {
            assertTrue(build("1100", 0, "PASS").isSuccess());
        }

        @Test
        @DisplayName("shouldReturnFalseWhenStatusNotZero")
        void shouldReturnFalseWhenStatusNotZero() {
            assertFalse(build("1100", 501, "PASS").isSuccess());
        }

        @Test
        @DisplayName("shouldReturnFalseWhenCodeNot1100")
        void shouldReturnFalseWhenCodeNot1100() {
            assertFalse(build("1200", 0, "PASS").isSuccess());
        }

        @Test
        @DisplayName("shouldReturnFalseWhenCodeNull")
        void shouldReturnFalseWhenCodeNull() {
            assertFalse(build(null, 0, "PASS").isSuccess());
        }
    }

    // ── isPass ──────────────────────────────────────────────────────────

    @Nested
    @DisplayName("isPass")
    class IsPass {

        @Test
        @DisplayName("shouldReturnTrueWhenPass")
        void shouldReturnTrueWhenPass() {
            assertTrue(build("1100", 0, "PASS").isPass());
        }

        @Test
        @DisplayName("shouldReturnFalseWhenReview")
        void shouldReturnFalseWhenReview() {
            assertFalse(build("1100", 0, "REVIEW").isPass());
        }

        @Test
        @DisplayName("shouldReturnFalseWhenNotSuccess")
        void shouldReturnFalseWhenNotSuccess() {
            assertFalse(build("1200", 0, "PASS").isPass());
        }
    }

    // ── isReview ────────────────────────────────────────────────────────

    @Nested
    @DisplayName("isReview")
    class IsReview {

        @Test
        @DisplayName("shouldReturnTrueWhenReview")
        void shouldReturnTrueWhenReview() {
            assertTrue(build("1100", 0, "REVIEW").isReview());
        }

        @Test
        @DisplayName("shouldReturnFalseWhenPass")
        void shouldReturnFalseWhenPass() {
            assertFalse(build("1100", 0, "PASS").isReview());
        }
    }

    // ── isReject ────────────────────────────────────────────────────────

    @Nested
    @DisplayName("isReject")
    class IsReject {

        @Test
        @DisplayName("shouldReturnTrueWhenReject")
        void shouldReturnTrueWhenReject() {
            assertTrue(build("1100", 0, "REJECT").isReject());
        }

        @Test
        @DisplayName("shouldReturnFalseWhenPass")
        void shouldReturnFalseWhenPass() {
            assertFalse(build("1100", 0, "PASS").isReject());
        }
    }

    // ── field accessors ─────────────────────────────────────────────────

    @Test
    @DisplayName("shouldSetAndGetTaskId")
    void shouldSetAndGetTaskId() {
        AntiFraudImageResponse r = new AntiFraudImageResponse();
        r.setTaskId("task-123");
        assertEquals("task-123", r.getTaskId());
    }

    @Test
    @DisplayName("shouldSetAndGetDetail")
    void shouldSetAndGetDetail() {
        AntiFraudImageResponse r = new AntiFraudImageResponse();
        AntiFraudImageDetail detail = new AntiFraudImageDetail();
        detail.setRiskType(100);
        r.setDetail(detail);
        assertNotNull(r.getDetail());
        assertEquals(100, r.getDetail().getRiskType());
    }

    @Test
    @DisplayName("shouldSetAndGetScore")
    void shouldSetAndGetScore() {
        AntiFraudImageResponse r = new AntiFraudImageResponse();
        r.setScore(500);
        assertEquals(500, r.getScore());
    }

    @Test
    @DisplayName("shouldSupportEqualsAndHashCode")
    void shouldSupportEqualsAndHashCode() {
        AntiFraudImageResponse a = build("1100", 0, "PASS");
        AntiFraudImageResponse b = build("1100", 0, "PASS");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportInequality")
    void shouldSupportInequality() {
        AntiFraudImageResponse a = build("1100", 0, "PASS");
        AntiFraudImageResponse b = build("1100", 0, "REJECT");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceToString")
    void shouldProduceToString() {
        AntiFraudImageResponse r = build("1100", 0, "PASS");
        String s = r.toString();
        assertTrue(s.contains("code=1100"));
    }
}
