package com.digimon.kotlineventbusspring

import com.digimon.kotlineventbusspring.eventbus.CoroutineEventBus
import com.digimon.kotlineventbusspring.eventbus.EventSubscriber
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class StringPubSubTest {

    @Test
    fun stringPubSubTest() = runBlocking {
        val eventBus = CoroutineEventBus()
        eventBus.register(StringSubscriber1())
        eventBus.register(StringSubscriber2())

        eventBus.post("Hello World")
    }
}


class StringSubscriber1 : EventSubscriber<String> {

    override fun onEvent(event: String) {
        println("StringSubscriber1: $event")
    }
}

class StringSubscriber2 : EventSubscriber<String> {

    override fun onEvent(event: String) {
        println("StringSubscriber2: $event")
    }
}