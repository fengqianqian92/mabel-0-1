package com.mabel.client

import com.mabel.model.Person

interface TestClient {
    fun get(id: String): Person
}