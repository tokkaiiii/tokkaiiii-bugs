package com.bugs.tokkaiiii.userservice.service

import com.bugs.tokkaiiii.userservice.repository.UserRepository
import org.jooq.generated.tables.pojos.BugsUser

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun saveUser(user: BugsUser): Long? {
        return userRepository.saveUser(user)
    }
}