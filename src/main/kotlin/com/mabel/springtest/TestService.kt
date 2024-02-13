package com.mabel.springtest

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TestService(
    private val testComponent: TestComponent,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun test() {
        logger.info("test test")
    }
}