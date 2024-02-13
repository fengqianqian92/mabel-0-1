package com.mabel.springtest

import org.springframework.stereotype.Service

@Service
class TestService2(
    private val testComponent: TestComponent,
) {
    private val testStr = "hello world"

    init {
        println(testStr)
    }

    fun test() {
        println(testStr)
    }

}