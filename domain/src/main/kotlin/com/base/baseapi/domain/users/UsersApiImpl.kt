package com.base.baseapi.domain.users

import com.base.baseapi.domain.util.Role
import org.springframework.stereotype.Service

@Service
class UsersApiImpl(
    private val usersDatabaseOperation: UsersDatabaseOperation
) : UsersApi {
    override suspend fun get(): List<User> {
        return listOf(User(123L, "userName", Role.USER))
        // return usersDatabaseOperation.get()
    }

    override suspend fun save(users: List<User>): List<User> {
        return usersDatabaseOperation.save(users)
    }

    override suspend fun delete(ids: List<Long>): String {
        return usersDatabaseOperation.delete(ids)
    }
}
