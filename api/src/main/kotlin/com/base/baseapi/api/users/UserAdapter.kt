package com.base.baseapi.api.users

import com.base.baseapi.domain.users.UsersApi
import org.springframework.stereotype.Service

@Service
internal class UserAdapter(
    private val usersApi: UsersApi
) {
    suspend fun get(): List<User> = usersApi.get().map { it.toResponse() }

    suspend fun save(users: List<User>): List<User> = usersApi.save(users.map { it.toDomain() }).map { it.toResponse() }

    suspend fun delete(ids: List<Long>): String = usersApi.delete(ids)
}
