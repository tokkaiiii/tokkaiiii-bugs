package com.bugs.tokkaiiii.userservice.service

import com.bugs.tokkaiiii.userservice.dto.request.RegisterRequest

interface UserService {

    fun saveUser(registerRequest: RegisterRequest): Long?

}