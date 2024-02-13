package com.mabel

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JsonRpcConfig {
    @Bean
    fun autoJsonExporter() : AutoJsonRpcServiceImplExporter {
        return AutoJsonRpcServiceImplExporter()
    }
}