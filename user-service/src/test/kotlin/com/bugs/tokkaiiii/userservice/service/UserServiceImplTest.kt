package com.bugs.tokkaiiii.userservice.service

import com.bugs.tokkaiiii.userservice.dto.request.RegisterRequest
import com.bugs.tokkaiiii.userservice.repository.UserRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class UserServiceImplTest{

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    @DisplayName("회원가입 테스트")
    @Transactional
    fun 회원가입(){
        // given
        val registerRequest = RegisterRequest(
            username = "test_usernmae",
            password = "test_password123",
            email = "test@naver.com"
        )

        // when
        val saveUserId = userService.saveUser(registerRequest)

        // then
        Assertions.assertThat(saveUserId).isNotNull
    }
}