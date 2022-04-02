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
        var fizzBuzzTextValue = "["

        for (i in 1..limit) {
            fizzBuzzTextValue += when {
                isFizzBuzzValue(i, int1) -> "$str1,"
                isFizzBuzzValue(i, int2) -> "$str2,"
                isFizzBuzzValue(i, int1) && isFizzBuzzValue(i, int2) -> "$str1$str2,"
                else -> "\"$i\","
            }
        }

        return "${removeLastComaFromText(fizzBuzzTextValue)}]"
    }

    private fun removeLastComaFromText(fizzBuzzTextValue: String) =
        fizzBuzzTextValue.subSequence(0, fizzBuzzTextValue.length - 1)

    private fun isFizzBuzzValue(value: Int, fizzBuzzValue: Int): Boolean {
        return value % fizzBuzzValue == 0
    }
}