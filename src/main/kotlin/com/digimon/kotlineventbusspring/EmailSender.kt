package com.digimon.kotlineventbusspring

import com.digimon.kotlineventbusspring.event.UserCreated
import com.digimon.kotlineventbusspring.eventbus.EventSubscriber
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class EmailSender : EventSubscriber<UserCreated> {

    val log = LoggerFactory.getLogger(this.javaClass)

    override fun onEvent(event: UserCreated) {

        log.info("sending email to ${event.user.email}")
    }

}
