package algorithm.leetcode.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MissingNumberTest {

    @ParameterizedTest
    @MethodSource("provider")
    void test(int[] nums, int expected) {
        MissingNumber solution = new MissingNumber();
        int actual = solution.missingNumber(nums);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
//                Arguments.of(new int[]{3, 0, 1}, 2),
//                Arguments.of(new int[]{0, 1}, 2),
                Arguments.of(new int[]{6, 9, 4, 2, 3, 5, 7, 0, 1}, 8)
        );
    }

}