package com.fizzbuzz.kwebfizzbuzz.api

import org.springframework.stereotype.Component

@Component
class FizzBuzzAdapter : FizzBuzzService {

    override fun getFizzBuzzTextValues(
        int1: Int,
        int2: Int,
        limit: Int,
        str1: String,
        str2: String
    ): String {
        val fizzBuzzTextValues = mutableListOf<String>()

        for (i in 1..limit) {
            fizzBuzzTextValues += when {
                isFizzBuzzValue(i, int1) && isFizzBuzzValue(i, int2) -> "$str1$str2"
                isFizzBuzzValue(i, int1) -> str1
                isFizzBuzzValue(i, int2) -> str2
                else -> i.toString()
            }
        }

        return fizzBuzzTextValues.joinToString(separator = ",", prefix = "[", postfix = "]") { "\"$it\"" }
    }

    private fun isFizzBuzzValue(value: Int, fizzBuzzValue: Int) = value % fizzBuzzValue == 0
}