package algorithm.leetcode.algorithm.dp;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        int answer = solution.numDecodings("226");
        System.out.println("answer = " + answer);
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;

        int lastChar = s.charAt(s.length() - 1) - '0';
        if (lastChar == 0) {
            dp[s.length() - 1] = 0;
        } else {
            dp[s.length() - 1] = 1;
        }

        for (int idx = s.length() - 2; idx >= 0; idx--) {
            int singleNumber = Integer.parseInt(s.substring(idx, idx + 1));
            int singleCount = 0;
            if (0 < singleNumber) {
                singleCount = dp[idx + 1];
            }

            int doubleNumber = Integer.parseInt(s.substring(idx, idx + 2));
            int doubleCount = 0;
            if (10 <= doubleNumber && doubleNumber <= 26) {
                doubleCount = dp[idx + 2];
            }

            dp[idx] = singleCount + doubleCount;
        }

        return dp[0];
    }

}
