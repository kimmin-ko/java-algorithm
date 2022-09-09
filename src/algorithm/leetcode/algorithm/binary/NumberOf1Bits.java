package algorithm.leetcode.algorithm.binary;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int res = n < 0 ? 1 : 0;
        int compare = 1;

        while (compare > 0) {
            int r = n ^ compare;
            if (n > r) {
                res++;
            }
            compare = compare << 1;
        }

        return res;
    }
}
