package algorithm.leetcode.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseBitsTest {

    @ParameterizedTest
    @MethodSource("provider")
    void test(int n, int expected) {
        ReverseBits solution = new ReverseBits();
        int actual = solution.reverseBits(n);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(43261596, 964176192)
        );
    }

}