package algorithm.leetcode.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int a = nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int threeSum = a + nums[l] + nums[r];
                if (threeSum == 0) {
                    results.add(List.of(a, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (threeSum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return results;
    }

}
