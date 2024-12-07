package com.bugs.tokkaiiii.userservice.dto.request

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)
