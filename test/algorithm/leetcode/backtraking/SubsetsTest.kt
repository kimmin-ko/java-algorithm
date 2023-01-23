package algorithm.leetcode.backtraking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubsetsTest {

    @Test
    fun subsets() {
        // given
        val solution = Subsets()

        // when
        val results = solution.subsets(intArrayOf(1, 2, 3))

        // then
        assertEquals(
            listOf(
                listOf(1, 2, 3),
                listOf(1, 2),
                listOf(1, 3),
                listOf(1),
                listOf(2, 3),
                listOf(2),
                listOf(3),
                listOf()
            ),
            results
        )
    }

}