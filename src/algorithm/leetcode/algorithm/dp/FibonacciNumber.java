package algorithm.leetcode.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciNumber {

    public int count;

    public static void main(String[] args) {
        int n = 10;

        FibonacciNumber e1 = new FibonacciNumber();
        int e1Result = e1.fiboNaive(n);
        System.out.println("e1.result = " + e1Result);
        System.out.println("e1.count = " + e1.count);

        System.out.println("----------------------");

        FibonacciNumber e2 = new FibonacciNumber();
        int e2Result = e2.fiboRecurDp(n);
        System.out.println("e2.result = " + e2Result);
        System.out.println("e2.count = " + e2.count);

        System.out.println("----------------------");

        FibonacciNumber e3 = new FibonacciNumber();
        int e3Result = e3.fiboDp(n);
        System.out.println("e3.result = " + e3Result);
        System.out.println("e3.count = " + e3.count);
    }

    public int fiboNaive(int n) {
        count++;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return fiboNaive(n - 1) + fiboNaive(n - 2);
    }

    private final List<Integer> fiboArr = new ArrayList<>(Arrays.asList(0, 1));

    // top down
    public int fiboRecurDp(int n) {
        count++;
        if (n < fiboArr.size()) {
            return fiboArr.get(n);
        }

        int res = fiboRecurDp(n - 1) + fiboRecurDp(n - 2);
        fiboArr.add(res);
        return res;
    }

    // bottom up
    public int fiboDp(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] fiboArr = new int[n + 1];
        fiboArr[0] = 0;
        fiboArr[1] = 1;

        for (int i = 2; i <= n; i++) {
            count++;
            fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
        }

        return fiboArr[n];
    }
}
