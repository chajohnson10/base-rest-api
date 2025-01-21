package com.base.baseapi.restclients.util

import io.klogging.Klogging
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.springframework.http.MediaType


interface BaseAdapter : Klogging {
    fun getHttpClient(): HttpClient {
        return HttpClient(CIO){
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