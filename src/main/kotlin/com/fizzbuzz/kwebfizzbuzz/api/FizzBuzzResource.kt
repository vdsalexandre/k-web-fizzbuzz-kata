package com.fizzbuzz.kwebfizzbuzz.api

import com.fizzbuzz.kwebfizzbuzz.bootstrap.Config.FIZZ_BUZZ_URL
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [FIZZ_BUZZ_URL], produces = ["application/json"])
class FizzBuzzResource(val fizzBuzzService: FizzBuzzService) {

    @GetMapping
    fun getFizzBuzzValue(
        @RequestParam(required = true) int1: Int,
        @RequestParam(required = true) int2: Int,
        @RequestParam(required = true) limit: Int,
        @RequestParam(required = true) str1: String,
        @RequestParam(required = true) str2: String,
    ): String {
        return fizzBuzzService.getFizzBuzzTextValues(int1, int2, limit, str1, str2)
    }
}