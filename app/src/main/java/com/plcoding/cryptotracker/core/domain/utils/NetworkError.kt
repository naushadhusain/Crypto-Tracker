package com.plcoding.cryptotracker.core.domain.utils

enum class NetworkError :Error {
    NO_INTERNET,
    PARSING_ERROR,
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN
}