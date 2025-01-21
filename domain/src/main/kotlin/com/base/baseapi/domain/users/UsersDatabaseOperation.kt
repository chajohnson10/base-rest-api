package com.base.baseapi.domain.users

interface UsersDatabaseOperation {
    suspend fun get(): List<User>

    suspend fun save(users: List<User>): List<User>

    suspend fun delete(ids: List<Long>): String
}
