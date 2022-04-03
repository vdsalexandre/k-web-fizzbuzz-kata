package com.fizzbuzz.kwebfizzbuzz.api

import com.fizzbuzz.kwebfizzbuzz.model.FizzBuzzParam
import org.springframework.stereotype.Service

@Service
interface FizzBuzzService {
    fun getFizzBuzzTextValues(fizzBuzzParam: FizzBuzzParam): String

    fun saveFizzBuzzParam(fizzBuzzParam: FizzBuzzParam)

    fun getMostUsedFizzBuzzParamsAsText(): String
}
