package algorithm.leetcode.dp;

import algorithm.leetcode.algorithm.dp.ClimbingStairs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ClimbingStairsTest {

    @ParameterizedTest
    @MethodSource("provider")
    void test(int n, int expected) {
        ClimbingStairs solution = new ClimbingStairs();
        int actual = solution.climbStairs(n);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3)
        );
    }


}