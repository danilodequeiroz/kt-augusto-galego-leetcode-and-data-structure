package chapter3

import kotlin.test.Test
import kotlin.test.assertEquals

class Class3BinarySearch {

    data class BinarySearchResult(
        val indexOfNumberFound: Int,
        val steps: Int,
    )

    fun binarySearch(numbers: Array<Int>, n: Int): BinarySearchResult {
        var pointerL = 0
        var pointerR: Int = numbers.size
        var steps = 0

        while (pointerL < pointerR) {
            steps++
            val mid: Int = (pointerL + pointerR) / 2
            if (numbers[mid] == n) {
                println("steps      :$steps")
                return BinarySearchResult(
                    indexOfNumberFound = mid,
                    steps = steps
                )
            } else if (numbers[mid] < n) {
                pointerL = mid + 1
            } else {
                pointerR = mid
            }
        }
        return BinarySearchResult(
            indexOfNumberFound = -1,
            steps = steps
        )
    }

    @Test
    fun testCase1() {
        val actual = binarySearch(arrayOf(1, 2, 3, 4, 5), 3)
        assertEquals(
            expected = 2,
            actual = actual.indexOfNumberFound
        )

        assertEquals(
            expected = 1,
            actual = actual.steps
        )
    }

    @Test
    fun testCase2() {
        val actual = binarySearch(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
        assertEquals(
            expected = 2,
            actual = actual.indexOfNumberFound
        )
        assertEquals(
            expected = 2,
            actual = actual.steps
        )
    }

    @Test
    fun testCase3() {
        val actual =
            binarySearch(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), 3)

        assertEquals(
            expected = 2,
            actual = actual.indexOfNumberFound
        )

        assertEquals(
            expected = 3,
            actual = actual.steps
        )
    }

}