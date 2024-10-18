package com.mabel.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.googlecode.jsonrpc4j.ProxyUtil
import com.googlecode.jsonrpc4j.spring.rest.JsonRpcRestClient
import com.mabel.client.TestClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URL

@Configuration
class JsonRpcClientConfig {

    @Bean
    fun testClient(): TestClient {
        val objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        return ProxyUtil.createClientProxy(
            TestClient::class.java,
            JsonRpcRestClient(URL("http://localhost:8080/test/TestService"), objectMapper, null, mapOf())
        )
    }
}