package com.example.demo1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class Demo1Application{

    @Bean
    fun restTemplate() = RestTemplate()
}

fun main(args: Array<String>) {
    runApplication<Demo1Application>(*args)
}

@RestController
class TestController(val restTemplate: RestTemplate){



    @GetMapping
    fun hello(): String{
        // var responseFromDemo2
        // var result = "Hello From Demo1" + responseFromDemo2
        // return result

        val responseFromDemo2 = restTemplate.getForObject("http://localhost:8082", String::class.java)
        val result = "Hello Kotlin World from Demo1 " + responseFromDemo2
        return result
    }
}