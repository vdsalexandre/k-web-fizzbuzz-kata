package com.fizzbuzz.kwebfizzbuzz.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FizzBuzzResource {

    @GetMapping("")
    fun getNumberValue() {

    }
}