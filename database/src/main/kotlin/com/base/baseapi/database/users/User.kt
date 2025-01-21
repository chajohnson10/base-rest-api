package com.base.baseapi.database.users

import com.base.baseapi.domain.util.Role
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import com.base.baseapi.domain.users.User as UserDomain

@Entity
@Table(name="users")
data class User(
    @Id @GeneratedValue
    val id: Long? = null,
    val name: String,
    val role: Role,
)

internal fun User.toDomain(): UserDomain =
    UserDomain(
        id = id,
        name = name,
        role = role
    )

internal fun UserDomain.toEntity(): User =
    User(
        id = id,
        name = name,
        role = role
    )
