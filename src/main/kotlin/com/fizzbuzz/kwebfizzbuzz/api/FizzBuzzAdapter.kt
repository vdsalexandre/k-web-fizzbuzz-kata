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
                isFizzBuzzValue(i, fizzBuzzParam.first) && isFizzBuzzValue(i, fizzBuzzParam.second) -> {
                    "${fizzBuzzParam.firstTextWord}${fizzBuzzParam.secondTextWord}"
                }
                isFizzBuzzValue(i, fizzBuzzParam.first) -> fizzBuzzParam.firstTextWord
                isFizzBuzzValue(i, fizzBuzzParam.second) -> fizzBuzzParam.secondTextWord
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

    override fun getMostUsedFizzBuzzParamsAsText(): String {
        val fizzBuzzParamAndCount = fizzBuzzParams.maxByOrNull { it.value }

        return if (fizzBuzzParamAndCount != null) {
            val fizzBuzzParam = fizzBuzzParamAndCount.key
            val count = fizzBuzzParamAndCount.value

            "{\"first\":\"" + fizzBuzzParam.first + "\"" +
                    ",\"second\":\"" + fizzBuzzParam.second + "\"" +
                    ",\"limit\":\"" + fizzBuzzParam.limit + "\"" +
                    ",\"firstTextWord\":\"" + fizzBuzzParam.firstTextWord + "\"" +
                    ",\"secondTextWord\":\"" + fizzBuzzParam.secondTextWord + "\"" +
                    ",\"count\":\"" + count + "\"}"
        } else
            "{ }"
    }

    private fun isFizzBuzzValue(value: Int, fizzBuzzValue: Int) = value % fizzBuzzValue == 0
}