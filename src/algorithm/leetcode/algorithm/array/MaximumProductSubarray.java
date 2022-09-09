package algorithm.leetcode.algorithm.array;

import java.util.Arrays;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();
        int result = solution.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println("result = " + result);
    }

    public int maxProduct(int[] nums) {
        int res = Arrays.stream(nums).max().orElse(0);

        int curMin = 1;
        int curMax = 1;
        for (int num : nums) {
            if (num == 0) {
                curMin = 1;
                curMax = 1;
                continue;
            }

            int tempMin = curMin * num;
            int tempMax = curMax * num;
            curMin = Math.min(Math.min(tempMin, tempMax), num);
            curMax = Math.max(Math.min(tempMin, tempMax), num);

            if (res < curMax) {
                res = curMax;
            }
        }

        return res;
    }
}
