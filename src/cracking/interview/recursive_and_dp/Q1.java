package cracking.interview.recursive_and_dp;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int topDown = q1.topDown(20);
        System.out.println("topDown = " + topDown);
        int bottomUp = q1.bottomUp(20);
        System.out.println("bottomUp = " + bottomUp);
    }

    private final Map<Integer, Integer> memory = new HashMap<>();

    public int topDown(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        if (memory.containsKey(n)) {
            return memory.get(n);
        }

        int sumStair = topDown(n - 1) + topDown(n - 2) + topDown(n - 3);
        memory.put(n, sumStair);
        return sumStair;
    }

    public int bottomUp(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] memory = new int[n + 1];
        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 4;
        for (int i = 4; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2] + memory[i - 3];
        }
        return memory[n];
    }
}
