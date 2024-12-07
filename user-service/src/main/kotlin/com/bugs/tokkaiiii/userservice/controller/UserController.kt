package com.bugs.tokkaiiii.userservice.controller

import com.bugs.tokkaiiii.userservice.dto.request.RegisterRequest
import com.bugs.tokkaiiii.userservice.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/register")
    fun registerUser(@RequestBody registerRequest: RegisterRequest) {
        userService.saveUser(registerRequest)
    }

}