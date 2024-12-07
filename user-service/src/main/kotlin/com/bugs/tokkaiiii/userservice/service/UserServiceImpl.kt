package com.bugs.tokkaiiii.userservice.service

import com.bugs.tokkaiiii.userservice.dto.request.RegisterRequest
import com.bugs.tokkaiiii.userservice.exception.DuplicatedUserException
import com.bugs.tokkaiiii.userservice.exception.UserNotFoundException
import com.bugs.tokkaiiii.userservice.repository.UserRepository
import org.jooq.generated.tables.pojos.BugsUser
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional(readOnly = true)
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun saveUser(registerRequest: RegisterRequest): Long? {
        userRepository.findByEmail(registerRequest.email)?: throw DuplicatedUserException("already exist user: ${registerRequest.email}")
        userRepository.findByUsername(registerRequest.username)?: throw DuplicatedUserException("already exist user: ${registerRequest.username}")
        val user = BugsUser(
            email = registerRequest.email,
            username = registerRequest.username,
            password = registerRequest.password,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
            )
        return userRepository.saveUser(user)
    }
}