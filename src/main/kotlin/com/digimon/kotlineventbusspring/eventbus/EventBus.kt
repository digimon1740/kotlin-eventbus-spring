package com.digimon.kotlineventbusspring.eventbus

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

interface EventSubscriber<out T> {

    fun onEvent(event: @UnsafeVariance T)
}

class CoroutineEventBus<T> {

    private val subscribers = mutableListOf<EventSubscriber<T>>()

    fun register(subscriber: EventSubscriber<T>) {
        subscribers.add(subscriber)
    }

    fun unregister(subscriber: EventSubscriber<T>) {
        subscribers.add(subscriber)
    }

    suspend fun post(event: T) = coroutineScope {
        subscribers.forEach {
            launch(Dispatchers.IO + SupervisorJob()) {
                it.onEvent(event)
            }
        }
    }

}

