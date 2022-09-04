package algorithm.leetcode.binary;

public class CountingBits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n == 0) {
            return res;
        }

        for (int i = 0; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }
}
