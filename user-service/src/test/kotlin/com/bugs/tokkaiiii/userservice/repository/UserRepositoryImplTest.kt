package com.bugs.tokkaiiii.userservice.repository

import com.bugs.tokkaiiii.userservice.exception.UserNotFoundException
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

    @Test
    @Transactional
    @DisplayName("유저 단건 조회 By Id")
    fun 유저_단건_조회(){
        // given
        val user = BugsUser()
        user.username = "test_username"
        user.email = "test_email"
        user.password = "test_password"
        user.createdAt = LocalDateTime.now()
        user.updatedAt = LocalDateTime.now()
        val userId = userRepository.saveUser(user)?: throw UserNotFoundException("User Not Found")

        // when
        val findUser = userRepository.findById(userId)?: throw UserNotFoundException("User Not Found")

        // then
        Assertions.assertThat(findUser).isNotNull
        Assertions.assertThat(findUser.username).isEqualTo("test_username")
    }

    @Test
    @Transactional
    @DisplayName("유저 단건 조회 By Email")
    fun 유저_단건_조회_By_Email(){
        // given
        val user = BugsUser()
        user.username = "test_username"
        user.email = "test_email"
        user.password = "test_password"
        user.createdAt = LocalDateTime.now()
        user.updatedAt = LocalDateTime.now()
        userRepository.saveUser(user)?: throw UserNotFoundException("User Not Found")

        // when
        val findUser = userRepository.findByEmail(user.email!!)?: throw UserNotFoundException("User Not Found")

        // then
        Assertions.assertThat(findUser.username).isEqualTo("test_username")

    }

    @Test
    @Transactional
    @DisplayName("유저 단건 조회 By Username")
    fun 유저_단건_조회_By_Username(){
        // given
        val user = BugsUser()
        user.username = "test_username"
        user.email = "test_email"
        user.password = "test_password"
        user.createdAt = LocalDateTime.now()
        user.updatedAt = LocalDateTime.now()
        userRepository.saveUser(user)?: throw UserNotFoundException("User Not Found")

        // when
        val findUser = userRepository.findByUsername("test_username")?: throw UserNotFoundException("User Not Found")

        // then
        Assertions.assertThat(findUser.email).isEqualTo("test_email")

    }

}