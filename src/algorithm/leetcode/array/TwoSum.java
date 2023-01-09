package algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] results = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(results));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int anotherKey = target - nums[i];
            if (map.containsKey(anotherKey)) {
                int anotherIndex = map.get(anotherKey);
                return new int[]{i, anotherIndex};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}