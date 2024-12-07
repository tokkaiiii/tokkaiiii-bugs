package com.bugs.tokkaiiii.userservice.domain

import java.time.LocalDateTime

class User(
    val id: Long,
    val email: String,
    val password: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)