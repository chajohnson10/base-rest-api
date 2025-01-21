package com.base.baseapi.restclients.util

import io.klogging.Klogging
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.springframework.http.MediaType

interface BaseAdapter : Klogging {
    fun getHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                        encodeDefaults = true
                    }
                )
            }
            HttpResponseValidator {
                handleResponseExceptionWithRequest { exception, request ->
                    logger.error("ex: $exception rq: $request")
                }
            }
            defaultRequest {
                header(HttpHeaders.Accept, MediaType.APPLICATION_JSON_VALUE)
                headers.append(HttpHeaders.ContentType, MediaType.APPLICATION_JSON_VALUE)
            }
            expectSuccess = false
        }
    }
}
