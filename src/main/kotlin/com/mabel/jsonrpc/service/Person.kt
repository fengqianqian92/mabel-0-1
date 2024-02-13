package com.mabel.jsonrpc.service

data class Person(
    val name: String
)

enum class TransactionViewsServiceError {
    NOT_FOUND,
    INVALID_ARGUMENT,
    NEGATIVE_PAGE_NUMBER,
    NEGATIVE_PAGE_SIZE,
    EXCEED_MAX_PAGE_NUMBER,
    EXCEED_MAX_PAGE_SIZE,
    BELOW_MIN_PAGE_SIZE,
    UNKNOWN_ERROR
}