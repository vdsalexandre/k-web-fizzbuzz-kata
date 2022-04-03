package com.fizzbuzz.kwebfizzbuzz.xspeed

class ChainCalculator {
    private companion object {
        const val SIZE_OF_BOX = 10
    }

    fun calculateTotalSize(chainOfArticles: String): Int {
        return chainOfArticles.map { it.digitToInt() }.sumOf { it }
    }

    fun calculateNumberOfBoxes(chainOfArticles: String): Int {
        var numberOfBoxes = 1
        var sumOfArticlesSize = 0

        chainOfArticles
            .map { it.digitToInt() }
            .forEach { articleSize ->
                if (sumOfArticlesSize + articleSize <= SIZE_OF_BOX)
                    sumOfArticlesSize += articleSize
                else {
                    sumOfArticlesSize = articleSize
                    numberOfBoxes++
                }
            }

        return numberOfBoxes
    }

    fun calculateOptimisedNumberOfBoxes(chainOfArticles: String): Int {
        return calculateTotalSize(chainOfArticles) / SIZE_OF_BOX + 1
    }
}
