package com.bugs.tokkaiiii.userservice.repository

import org.assertj.core.api.Assertions
import org.jooq.generated.tables.pojos.BugsUser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@SpringBootTest
class UserRepositoryImplTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @DisplayName("회원가입 기본")
    @Transactional
    @Test
    fun 회원가입_기본() {
        // given
        val user = BugsUser()
        user.username = "test_username"
        user.email = "test_email"
        user.password = "test_password"
        user.createdAt = LocalDateTime.now()
        user.updatedAt = LocalDateTime.now()
        val user1 = BugsUser()
        user1.username = "test_username1"
        user1.email = "test_email1"
        user1.password = "test_password1"
        user1.createdAt = LocalDateTime.now()
        user1.updatedAt = LocalDateTime.now()

        // when
        val userId = userRepository.saveUser(user)
        val userId1 = userRepository.saveUser(user1)

        // then
        Assertions.assertThat(userId).isNotNull
        Assertions.assertThat(userId1).isNotNull
    }
}