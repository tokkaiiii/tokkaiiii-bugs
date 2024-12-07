package com.bugs.tokkaiiii.userservice.service

import com.bugs.tokkaiiii.userservice.repository.UserRepository
import org.jooq.generated.tables.pojos.BugsUser
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun saveUser(user: BugsUser): Long? {
        return userRepository.saveUser(user)
    }
}