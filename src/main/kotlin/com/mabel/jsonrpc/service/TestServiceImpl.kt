package com.mabel.jsonrpc.service

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl
import org.springframework.stereotype.Service

@AutoJsonRpcServiceImpl
@Service
class TestServiceImpl : TestService {
    override fun get(id: String): JsonNode {
        return ObjectMapper().readTree("{\"right\":{\"name\":\"mabel\"}}")
    }
}