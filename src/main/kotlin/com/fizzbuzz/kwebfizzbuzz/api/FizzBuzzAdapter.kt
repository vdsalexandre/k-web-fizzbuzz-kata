package com.fizzbuzz.kwebfizzbuzz.api

import com.fizzbuzz.kwebfizzbuzz.model.FizzBuzzParam
import org.springframework.stereotype.Component

@Component
class FizzBuzzAdapter : FizzBuzzService {
    private val fizzBuzzParams = mutableMapOf<FizzBuzzParam, Int>()

    override fun getFizzBuzzTextValues(fizzBuzzParam: FizzBuzzParam): String {
        val fizzBuzzTextValues = mutableListOf<String>()

        for (i in 1..fizzBuzzParam.limit) {
            fizzBuzzTextValues += when {
                isFizzBuzzValue(i, fizzBuzzParam.int1) && isFizzBuzzValue(i, fizzBuzzParam.int2) -> {
                    "${fizzBuzzParam.str1}${fizzBuzzParam.str2}"
                }
                isFizzBuzzValue(i, fizzBuzzParam.int1) -> fizzBuzzParam.str1
                isFizzBuzzValue(i, fizzBuzzParam.int2) -> fizzBuzzParam.str2
                else -> i.toString()
            }
        }

        return fizzBuzzTextValues.joinToString(separator = ",", prefix = "[", postfix = "]") { "\"$it\"" }
    }

    override fun saveFizzBuzzParam(fizzBuzzParam: FizzBuzzParam) {
        if (fizzBuzzParams.contains(fizzBuzzParam)) {
            val count = fizzBuzzParams.getValue(fizzBuzzParam)
            fizzBuzzParams.replace(fizzBuzzParam, count + 1)
        } else {
            fizzBuzzParams[fizzBuzzParam] = 1
        }
    }

    override fun getMostParamUsed(): String {
        val entry = fizzBuzzParams.maxByOrNull { it.value }

        return if (entry != null) {
            val param = entry.key

            "{\"int1\":\"" + param.int1 + "\"" +
                    ",\"int2\":\"" + param.int2 + "\"" +
                    ",\"limit\":\"" + param.limit + "\"" +
                    ",\"str1\":\"" + param.str1 + "\"" +
                    ",\"str2\":\"" + param.str2 + "\"" +
                    ",\"count\":\"" + entry.value + "\"}"
        } else
            "{ }"
    }

    private fun isFizzBuzzValue(value: Int, fizzBuzzValue: Int) = value % fizzBuzzValue == 0
}