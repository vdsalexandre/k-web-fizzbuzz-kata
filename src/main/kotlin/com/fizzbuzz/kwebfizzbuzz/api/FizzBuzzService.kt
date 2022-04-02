package com.fizzbuzz.kwebfizzbuzz.api

import org.springframework.stereotype.Service

@Service
interface FizzBuzzService {
    fun getFizzBuzzTextValues(
        int1: Int,
        int2: Int,
        limit: Int,
        str1: String,
        str2: String
    ): String
}
