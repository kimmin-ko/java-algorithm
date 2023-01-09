package algorithm.leetcode.dp;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange s = new CoinChange();
        int answer = s.coinChange(new int[]{2}, 1);
        System.out.println("answer = " + answer);

        CoinChange s1 = new CoinChange();
        int answer1 = s1.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("answer1 = " + answer1);
    }

    // bottom up
    public int coinChange(int[] coins, int amount) {
        int[] m = new int[amount + 1];
        m[0] = 0;

        for (int i = 1; i < m.length; i++) {
            int minimumCoin = getMinimumCoin(coins, m, i);
            if (minimumCoin < 0) {
                m[i] = -1;
                continue;
            }
            m[i] = minimumCoin + 1;
        }

        return m[amount];
    }

    private int getMinimumCoin(int[] coins, int[] m, int n) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int memoryValue = n - coin >= 0 ? m[n - coin] : -1;
            if (memoryValue < min && memoryValue >= 0) {
                min = memoryValue;
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
}
