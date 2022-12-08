package algorithm.leetcode.algorithm.dp;

public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray s = new MaximumSubArray();
        int answer = s.maxSubArray(new int[]{5,4,-1,7,8});
        System.out.println("answer = " + answer);
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int answer = dp[0];
        for (int i = 1; i < nums.length; i++) {
             dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }

        return answer;
    }
}
