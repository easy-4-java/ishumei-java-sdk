package com.ishumei.spring.boot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AntiFraudResponse}.
 */
@DisplayName("AntiFraudResponse")
class AntiFraudResponseTest {

    private AntiFraudResponse build(String code, int status, String riskLevel) {
        AntiFraudResponse r = new AntiFraudResponse();
        r.setCode(code);
        r.setStatus(status);
        r.setRiskLevel(riskLevel);
        return r;
    }

    // ── field defaults ──────────────────────────────────────────────────

    @Test
    @DisplayName("shouldCreateWithDefaults")
    void shouldCreateWithDefaults() {
        AntiFraudResponse r = new AntiFraudResponse();
        assertNull(r.getCode());
        assertNull(r.getMessage());
        assertNull(r.getRequestId());
        assertEquals(0, r.getScore());
        assertNull(r.getRiskLevel());
        assertEquals(0, r.getStatus());
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
        @DisplayName("shouldThrowNpeWhenCodeNull")
        void shouldThrowNpeWhenCodeNull() {
            assertThrows(NullPointerException.class,
                    () -> build(null, 0, "PASS").isSuccess());
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
    @DisplayName("shouldSetAndGetCode")
    void shouldSetAndGetCode() {
        AntiFraudResponse r = new AntiFraudResponse();
        r.setCode("1100");
        assertEquals("1100", r.getCode());
    }

    @Test
    @DisplayName("shouldSetAndGetMessage")
    void shouldSetAndGetMessage() {
        AntiFraudResponse r = new AntiFraudResponse();
        r.setMessage("ok");
        assertEquals("ok", r.getMessage());
    }

    @Test
    @DisplayName("shouldSetAndGetRequestId")
    void shouldSetAndGetRequestId() {
        AntiFraudResponse r = new AntiFraudResponse();
        r.setRequestId("req-1");
        assertEquals("req-1", r.getRequestId());
    }

    @Test
    @DisplayName("shouldSetAndGetScore")
    void shouldSetAndGetScore() {
        AntiFraudResponse r = new AntiFraudResponse();
        r.setScore(850);
        assertEquals(850, r.getScore());
    }

    @Test
    @DisplayName("shouldSetAndGetDetail")
    void shouldSetAndGetDetail() {
        AntiFraudResponse r = new AntiFraudResponse();
        r.setDetail("{\"riskType\":100}");
        assertEquals("{\"riskType\":100}", r.getDetail());
    }

    @Test
    @DisplayName("shouldSupportEqualsAndHashCode")
    void shouldSupportEqualsAndHashCode() {
        AntiFraudResponse a = build("1100", 0, "PASS");
        AntiFraudResponse b = build("1100", 0, "PASS");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("shouldSupportInequality")
    void shouldSupportInequality() {
        AntiFraudResponse a = build("1100", 0, "PASS");
        AntiFraudResponse b = build("1100", 0, "REJECT");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("shouldProduceToString")
    void shouldProduceToString() {
        AntiFraudResponse r = build("1100", 0, "PASS");
        String s = r.toString();
        assertTrue(s.contains("code=1100"));
    }
}
