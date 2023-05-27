package com.digimon.kotlineventbusspring.service

import com.digimon.kotlineventbusspring.domain.User
import com.digimon.kotlineventbusspring.domain.UserRepository
import com.digimon.kotlineventbusspring.dto.UserRequest
import com.digimon.kotlineventbusspring.event.UserCreated
import com.digimon.kotlineventbusspring.eventbus.CoroutineEventBus
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userEventBus: CoroutineEventBus<UserCreated>,
) {

    suspend fun createUser(userRequest: UserRequest) {

        val user = User(name = userRequest.name, email = userRequest.email)
        userRepository.save(user)

        userEventBus.post(UserCreated(user))
    }
}


