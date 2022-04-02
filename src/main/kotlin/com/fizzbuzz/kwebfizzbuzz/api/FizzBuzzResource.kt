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
                "int1: ${fizzBuzzParam.int1}, " +
                "int2: ${fizzBuzzParam.int2}, " +
                "limit: ${fizzBuzzParam.limit}, " +
                "str1: ${fizzBuzzParam.str1}, " +
                "str2: ${fizzBuzzParam.str2}"
        )
        fizzBuzzService.saveFizzBuzzParam(fizzBuzzParam)
        return fizzBuzzService.getFizzBuzzTextValues(fizzBuzzParam)
    }

    @GetMapping(value = ["/statistics"], produces = ["application/json"])
    fun getFizzBuzzStatistics(): String {
        val mostUsedParam = fizzBuzzService.getMostParamUsed()
        logger.info("getFizzBuzzStatistics> $mostUsedParam")
        return mostUsedParam
    }
}