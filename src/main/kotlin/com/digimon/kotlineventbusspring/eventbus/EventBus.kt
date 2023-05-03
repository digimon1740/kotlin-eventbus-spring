package com.digimon.kotlineventbusspring.eventbus

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

interface EventSubscriber<out T> {

    fun onEvent(event: @UnsafeVariance T)
}

class CoroutineEventBus {

    private val subscribers = mutableListOf<EventSubscriber<out Any>>()

    fun register(subscriber: EventSubscriber<out Any>) {
        subscribers.add(subscriber)
    }

    fun unregister(subscriber: EventSubscriber<out Any>) {
        subscribers.add(subscriber)
    }

    suspend fun post(event: Any) = coroutineScope {
        subscribers.forEach {
            launch(Dispatchers.IO + SupervisorJob()) {
                it.onEvent(event)
            }
        }
    }

}

