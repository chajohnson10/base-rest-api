package com.base.baseapi.restclients.foo

import com.base.baseapi.domain.restports.FooApi
import com.base.baseapi.restclients.util.ApiConfig
import com.base.baseapi.restclients.util.BaseAdapter
import io.klogging.Klogging
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.springframework.stereotype.Service

@Service
internal class FooApiAdapter(
    private val apiConfig: ApiConfig
): BaseAdapter, Klogging, FooApi {
    override suspend fun getData(): String {
        return try{
            val url = apiConfig.baseUrl
            val response: HttpResponse = getHttpClient().use { httpClient ->
                httpClient.get(url)
            }
            if(response.status.value != 200){
                logger.error { "Error retrieving data from api: ${response.status}" }
            }
            response.body<String>()
        }catch (ex: Exception){
            logger.error("ex: $ex")
            "ex: $ex"
        }
    }
    override suspend fun postData(): String {
        return try{
            val url = apiConfig.baseUrl
            val response: HttpResponse = getHttpClient().use { httpClient ->
                httpClient.post(url){
                    setBody("")
                }
            }
            if(response.status.value != 200){
                logger.error { "Error retrieving data from api: ${response.status}" }
            }
            response.body<String>()
        }catch (ex: Exception){
            logger.error("Exception retrieving data from api ex: $ex")
            "Exception retrieving data from api ex: $ex"
        }
    }
}