package com.digimon.kotlineventbusspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinEventbusSpringApplication

fun main(args: Array<String>) {
    runApplication<KotlinEventbusSpringApplication>(*args)
}
