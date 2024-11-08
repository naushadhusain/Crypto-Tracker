package com.plcoding.cryptotracker.core.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {
    fun create(engine: HttpClientEngine, isDebug: Boolean=true): HttpClient {
        return HttpClient(engine) {
            install(Logging) {
                level = if (isDebug) LogLevel.ALL else LogLevel.NONE
                logger = Logger.ANDROID
            }
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                        prettyPrint = isDebug
                    }
                )
            }
//            install(HttpTimeout) {
//                requestTimeoutMillis = 15000 // 15 seconds timeout
//                connectTimeoutMillis = 10000 // 10 seconds connect timeout
//                socketTimeoutMillis = 15000 // 15 seconds for socket timeout
//            }
            defaultRequest {
                contentType(ContentType.Application.Json)
//                url(baseUrl)
            }


        }
    }
}





//import io.ktor.client.plugins.HttpResponseValidator
//import io.ktor.client.statement.*
//import io.ktor.http.*
//
//object HttpClientFactory {
//    fun create(
//        engine: HttpClientEngine,
//        isDebug: Boolean = true,
//        baseUrl: String
//    ): HttpClient {
//        return HttpClient(engine) {
//            install(Logging) {
//                level = if (isDebug) LogLevel.ALL else LogLevel.NONE
//                logger = Logger.ANDROID
//            }
//            install(ContentNegotiation) {
//                json(
//                    json = Json {
//                        ignoreUnknownKeys = true
//                        prettyPrint = isDebug
//                    }
//                )
//            }
//            install(HttpTimeout) {
//                requestTimeoutMillis = 15_000
//                connectTimeoutMillis = 10_000
//                socketTimeoutMillis = 15_000
//            }
//            install(HttpResponseValidator) {
//                validateResponse { response: HttpResponse ->
//                    if (response.status.value in 400..599) {
//                        throw Exception("HTTP Error: ${response.status}")
//                    }
//                }
//                handleResponseExceptionWithRequest { exception, _ ->
//                    throw Exception("Network Error: ${exception.localizedMessage}")
//                }
//            }
//            defaultRequest {
//                contentType(ContentType.Application.Json)
//                url(baseUrl)
//            }
//        }
//    }
//}
