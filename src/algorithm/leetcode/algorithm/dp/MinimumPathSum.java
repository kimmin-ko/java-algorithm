package algorithm.leetcode.algorithm.dp;

public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum s = new MinimumPathSum();
        int result = s.minPathSum(new int[][]{
                {1, 3, 1, 2},
                {2, 4, 5, 2},
                {3, 4, 5, 6},
                {1, 5, 6, 2}
        });

        System.out.println("result = " + result);
    }

    // 내가 직접 푼거
    public int minPathSum(int[][] G) {
        int yLength = G.length;
        int xLength = G[0].length;

        int[][] F = new int[yLength][xLength];
        F[0][0] = G[0][0];

        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                if (y == 0 && x == 0) {
                    continue;
                } else if (y == 0) {
                    F[y][x] = F[y][x - 1] + G[y][x];
                    continue;
                } else if (x == 0) {
                    F[y][x] = F[y - 1][x] + G[y][x];
                    continue;
                }

                F[y][x] = Math.min(F[y - 1][x], F[y][x - 1]) + G[y][x];
            }
        }

        return F[yLength - 1][xLength - 1];
    }
}
