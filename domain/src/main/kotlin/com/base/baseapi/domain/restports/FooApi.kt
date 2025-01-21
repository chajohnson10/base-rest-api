package com.base.baseapi.domain.restports

interface FooApi {
    suspend fun getData(): String
    suspend fun postData(): String
}
