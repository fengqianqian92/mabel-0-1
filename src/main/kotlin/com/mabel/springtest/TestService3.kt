package com.mabel.springtest

import com.mabel.client.TestClient
import com.mabel.jsonrpc.service.TestServiceImpl
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service


class TestService3(
    private val TestServiceImpl: TestServiceImpl,
    private val testClient: TestClient
) : InitializingBean {
    override fun afterPropertiesSet() {
        testClient.get("1")
    }

}