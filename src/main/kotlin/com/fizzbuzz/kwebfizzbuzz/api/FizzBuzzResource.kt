package com.fizzbuzz.kwebfizzbuzz.api

import com.fizzbuzz.kwebfizzbuzz.bootstrap.Config.FIZZ_BUZZ_URL
import com.fizzbuzz.kwebfizzbuzz.model.FizzBuzzParam
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [FIZZ_BUZZ_URL], produces = ["application/json"])
class FizzBuzzResource(val fizzBuzzService: FizzBuzzService) {

    private val logger = LoggerFactory.getLogger(FizzBuzzResource::class.java)

    @PostMapping
    fun calculateFizzBuzzValues(@RequestBody fizzBuzzParam: FizzBuzzParam): String {
        logger.info("getFizzBuzzValues> " +
                "first: ${fizzBuzzParam.first}, " +
                "second: ${fizzBuzzParam.second}, " +
                "limit: ${fizzBuzzParam.limit}, " +
                "firstTextWord: ${fizzBuzzParam.firstTextWord}, " +
                "secondTextWord: ${fizzBuzzParam.secondTextWord}"
        )
        fizzBuzzService.saveFizzBuzzParam(fizzBuzzParam)
        return fizzBuzzService.getFizzBuzzTextValues(fizzBuzzParam)
    }

    @GetMapping(value = ["/statistics"], produces = ["application/json"])
    fun getFizzBuzzStatistics(): String {
        val mostUsedParam = fizzBuzzService.getMostUsedFizzBuzzParamsAsText()
        logger.info("getFizzBuzzStatistics> $mostUsedParam")
        return mostUsedParam
    }
}