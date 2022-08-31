package algorithm.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.List;

class ThreeSumTest {

    @Test
    void test() {
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }

}