package algorithm.leetcode.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberOf1BitsTest {

    @ParameterizedTest
    @CsvSource(value = {"11:3", "256:1", "-2:31"}, delimiter = ':')
    void test(int n, int expected) {
        NumberOf1Bits solution = new NumberOf1Bits();
        int result = solution.hammingWeight(n);

        Assertions.assertEquals(expected, result);
    }
}