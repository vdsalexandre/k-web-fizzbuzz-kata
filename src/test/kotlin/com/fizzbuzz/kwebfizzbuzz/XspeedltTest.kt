package com.fizzbuzz.kwebfizzbuzz

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.fizzbuzz.kwebfizzbuzz.xspeed.ChainCalculator
import org.junit.jupiter.api.Test

class XspeedltTest {

    @Test
    internal fun `should calculate total size of all articles from a chain of articles`() {
        val chainOfArticles = "163841689525773"
        val expectedResult = 75

        val chainCalculator = ChainCalculator()
        val result = chainCalculator.calculateTotalSize(chainOfArticles)

        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    internal fun `should calculate number of boxes to contain all articles from a chain of articles`() {
        val chainOfArticles = "163841689525773"
        val expectedResult = 10

        val chainCalculator = ChainCalculator()
        val result = chainCalculator.calculateNumberOfBoxes(chainOfArticles)

        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    internal fun `should calculate optimised number of boxes to contain all articles from a chain of articles`() {
        val chainOfArticles = "163841689525773"
        val expectedResult = 8

        val chainCalculator = ChainCalculator()
        val result = chainCalculator.calculateOptimisedNumberOfBoxes(chainOfArticles)

        assertThat(result).isEqualTo(expectedResult)
    }
}