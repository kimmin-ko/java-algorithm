package algorithm.leetcode.binary;

import algorithm.leetcode.algorithm.binary.CountingBits;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountingBitsTest {


    @ParameterizedTest
    @MethodSource("provider")
    void test(int n, int[] expected) {
        CountingBits solution = new CountingBits();
        int[] actual = solution.countBits(n);
        Assertions.assertArrayEquals(actual, expected);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(2, new int[]{0, 1, 1}),
                Arguments.of(5, new int[]{0, 1, 1, 2, 1, 2})
        );
    }

}