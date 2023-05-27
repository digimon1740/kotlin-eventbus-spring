package com.digimon.kotlineventbusspring.config

import com.digimon.kotlineventbusspring.EmailSender
import com.digimon.kotlineventbusspring.event.UserCreated
import com.digimon.kotlineventbusspring.eventbus.CoroutineEventBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventBusConfig(
    private val welcomeEmailSender: EmailSender,
) {


    @Bean
    fun userEventBus() = CoroutineEventBus<UserCreated>().apply {
        register(welcomeEmailSender)
    }


}