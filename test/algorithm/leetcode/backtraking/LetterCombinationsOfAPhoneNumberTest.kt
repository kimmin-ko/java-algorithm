package algorithm.leetcode.backtraking

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LetterCombinationsOfAPhoneNumberTest {

    @ParameterizedTest
    @MethodSource("getDigitsAndAnswer")
    fun test(digits: String, expected: List<String>) {
        val solution = LetterCombinationsOfAPhoneNumber()
        val actual = solution.letterCombinations(digits)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        private fun getDigitsAndAnswer(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("", listOf<String>()),
                Arguments.of("2", listOf("a", "b", "c")),
                Arguments.of("23", listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
            )
        }
    }
}