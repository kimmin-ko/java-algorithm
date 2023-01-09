package algorithm.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci2 {

    static int fiboNaiveCount;
    static int fiboTopDownCount;
    static int fiboBottomupCount;

    public static void main(String[] args) {
        Fibonacci2 f = new Fibonacci2();
//        int fiboNaive = f.fiboNaive(n);
//        System.out.println("fiboNaive = " + fiboNaive);
//        System.out.println("fiboNaiveCount = " + fiboNaiveCount);

        long fiboTopDown = f.fiboTopDown(5000);
        System.out.println("fiboTopDown = " + fiboTopDown);
        System.out.println("fiboRecurDpCount = " + fiboTopDownCount);

        long fiboBottonUp = f.fiboBottonUp(5000);
        System.out.println("fiboBottonUp = " + fiboBottonUp);
        System.out.println("fiboBottomupCount = " + fiboBottomupCount);
    }

    int fiboNaive(int n) {
        fiboNaiveCount++;
        if (n == 0 || n == 1) {
            return n;
        }

        return fiboNaive(n - 1) + fiboNaive(n - 2);
    }

    /**
     * top down
     * 큰 값을 구하려고하면 StackOverflowError 발생
     * 이유: n부터 1까지 스택이 메모리에 쌓이기 때문이다.
     * 해당 에러는 bottom up 방식응로 해결할 수 있다.
     */
    List<Long> recurDpArray = new ArrayList<>(List.of(0L, 1L));

    long fiboTopDown(int n) {
        fiboTopDownCount++;

        if (n < recurDpArray.size()) {
            return recurDpArray.get(n);
        }

        recurDpArray.add(fiboTopDown(n - 1) + fiboTopDown(n - 2));
        return recurDpArray.get(n);
    }

    long fiboBottonUp(int n) {
        fiboBottomupCount++;

        if (n == 0 || n == 1) {
            return n;
        }

        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            fiboBottomupCount++;
            long res = arr[i - 1] + arr[i - 2];
            arr[i] = res;
        }

        return arr[n];
    }

}
