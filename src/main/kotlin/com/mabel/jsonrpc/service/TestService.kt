package com.mabel.jsonrpc.service

import com.fasterxml.jackson.databind.JsonNode
import com.googlecode.jsonrpc4j.JsonRpcParam
import com.googlecode.jsonrpc4j.JsonRpcService

@JsonRpcService("/test/TestService")
interface TestService {
    fun get(@JsonRpcParam("id") id: String): JsonNode
}