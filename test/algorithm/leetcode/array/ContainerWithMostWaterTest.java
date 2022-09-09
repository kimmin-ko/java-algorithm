package algorithm.leetcode.array;

import algorithm.leetcode.algorithm.array.ContainerWithMostWater;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    @ParameterizedTest
    @MethodSource("provider")
    void test(int[] height, int expected) {
        // given
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // when
        int result = solution.maxArea(height);

        // then
        assertEquals(result, expected);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1)
        );
    }

}