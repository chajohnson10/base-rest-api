package com.base.baseapi.domain.users

import com.base.baseapi.domain.util.Role

data class User(
    val id: Long?,
    val name: String,
    val role: Role
)
