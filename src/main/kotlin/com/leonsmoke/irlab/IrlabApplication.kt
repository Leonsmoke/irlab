package com.leonsmoke.irlab

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
@EnableAutoConfiguration
class IrlabApplication: SpringBootServletInitializer()

fun main(args: Array<String>) {
	runApplication<IrlabApplication>(*args)
}
