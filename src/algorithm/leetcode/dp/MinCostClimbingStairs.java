package algorithm.leetcode.dp;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs s = new MinCostClimbingStairs();
        int answer = s.minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println("answer = " + answer);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n <= 1) {
            return 0;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;
        //  cost 10,15,20
        for (int i = 2; i <= n; i++) {
            arr[i] = Math.min(cost[i - 1] + arr[i - 1], cost[i - 2] + arr[i - 2]);
        }

        return arr[n];
    }
}
