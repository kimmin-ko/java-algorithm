package algorithm.leetcode.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumOfTwoIntegersTest {


    @ParameterizedTest
    @MethodSource("provider")
    void test(int a, int b, int expected) {
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        int actual = solution.getSum(a, b);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(1, 3, 4)
        );
    }
}