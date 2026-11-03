package com.ishumei.spring.boot.model;

import tools.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonRoundTripTest {

    @Test
    void textRequestRoundTripPreservesWireFields() throws Exception {
        JsonMapper mapper = JsonMapper.builder().build();
        AntiFraudTextRequest request = new AntiFraudTextRequest();
        request.setAccessKey("test-key");
        request.setType("ECOM");
        AntiFraudTextRequestData data = new AntiFraudTextRequestData();
        data.setText("hello world");
        data.setNickname("alice");
        request.setData(data);

        String json = mapper.writeValueAsString(request);
        assertTrue(json.contains("\"appId\":\"default\""));
        assertTrue(json.contains("\"text\":\"hello world\""));

        AntiFraudTextRequest decoded = mapper.readValue(json, AntiFraudTextRequest.class);
        assertEquals("default", decoded.getAppId());
        assertEquals("test-key", decoded.getAccessKey());
        assertEquals("ECOM", decoded.getType());
        assertEquals("hello world", decoded.getData().getText());
        assertEquals("alice", decoded.getData().getNickname());
    }

    @Test
    void responseRoundTripPreservesRiskDecision() throws Exception {
        JsonMapper mapper = JsonMapper.builder().build();
        String json = "{\"code\":\"1100\",\"status\":0,\"riskLevel\":\"PASS\","
                + "\"requestId\":\"req-123\",\"score\":42,\"detail\":\"{}\","
                + "\"futureField\":\"ignored\"}";

        AntiFraudResponse response = mapper.readValue(json, AntiFraudResponse.class);
        assertTrue(response.isSuccess());
        assertTrue(response.isPass());
        assertEquals("req-123", response.getRequestId());
        assertEquals("{}", response.getDetail());

        AntiFraudResponse decoded = mapper.readValue(
                mapper.writeValueAsString(response), AntiFraudResponse.class);
        assertEquals("1100", decoded.getCode());
        assertEquals(42, decoded.getScore());
        assertEquals("PASS", decoded.getRiskLevel());
    }
}
