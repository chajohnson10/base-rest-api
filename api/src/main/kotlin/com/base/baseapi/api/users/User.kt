package com.base.baseapi.api.users

import com.base.baseapi.domain.util.Role
import kotlinx.serialization.Serializable
import com.base.baseapi.domain.users.User as UserDomain

@Serializable
data class User(
    val id: Long? = null,
    val name: String,
    val role: Role
)

internal fun UserDomain.toResponse(): User =
    User(
        id = id,
        name = name,
        role = role
    )

internal fun User.toDomain(): UserDomain =
    UserDomain(
        id = id,
        name = name,
        role = role
    )
