package algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        boolean result = solution.containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println("result = " + result);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> compactNums = new HashSet<>();
        for (int num : nums) {
            if (compactNums.contains(num)) {
                return true;
            }
            compactNums.add(num);
        }
        return false;
    }
}
