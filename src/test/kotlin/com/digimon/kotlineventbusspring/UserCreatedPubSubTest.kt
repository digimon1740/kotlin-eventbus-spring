package com.digimon.kotlineventbusspring

import com.digimon.kotlineventbusspring.dto.UserRequest
import com.digimon.kotlineventbusspring.service.UserService
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserCreatedPubSubTest {

    @Autowired
    lateinit var userService: UserService

    @Test
    fun userCreatedPubSubTest() = runBlocking {
        userService.createUser(UserRequest("kazuya", "kazuya@gmail.com"))
    }
}