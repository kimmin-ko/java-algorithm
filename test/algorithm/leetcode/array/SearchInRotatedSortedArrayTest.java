package algorithm.leetcode.array;

import algorithm.leetcode.algorithm.array.SearchInRotatedSortedArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("provider")
    void test(int[] nums, int target, int expected) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int actual = solution.search(nums, target);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{1}, 0, -1),
                Arguments.of(new int[]{5, 1, 3}, 5, 0)
        );
    }
}