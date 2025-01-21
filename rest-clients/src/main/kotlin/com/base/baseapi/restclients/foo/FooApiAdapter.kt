package com.base.baseapi.restclients.foo

import com.base.baseapi.restclients.util.ApiConfig
import com.base.baseapi.restclients.util.BaseAdapter
import io.klogging.Klogging
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.springframework.stereotype.Service

@Service
internal class FooApiAdapter(
    private val apiConfig: ApiConfig
): BaseAdapter, Klogging {
    suspend fun getData(): String {
        return try{
            val url = apiConfig.baseUrl
            getHttpClient().use { httpClient ->
                httpClient.post(url){
                    setBody("")
                }
            }.body()
        }catch (ex: Exception){
            logger.error("ex: $ex")
            "ex: $ex"
        }
    }
}