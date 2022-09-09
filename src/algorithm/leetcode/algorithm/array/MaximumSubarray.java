package algorithm.leetcode.algorithm.array;

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int result = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("result = " + result);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        int[] tempArr = new int[n];
        tempArr[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (tempArr[i - 1] > 0) {
                tempArr[i] = tempArr[i - 1] + nums[i];
            }else {
                tempArr[i] = nums[i];
            }
            max = Math.max(max, tempArr[i]);
        }
        return max;
    }
}
