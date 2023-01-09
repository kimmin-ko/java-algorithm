package algorithm.leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClimbingStairs {

    // top down
    List<Integer> list = new ArrayList<>();
    Set<Integer> flag = new HashSet<>();

    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        if (flag.contains(n)) {
            return 0;
        }

        if (list.size() > n) {
            flag.add(n);
            return list.get(n);
        }

        int stairs = climbStairs(n - 2) + climbStairs(n - 1);
        list.add(stairs);
        return stairs;
    }

    // bottom up
    public int climbStairsBU(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[n];
    }
}
