package algorithm.leetcode.array;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int curWidth = r - l;
            int lowHeight = Math.min(height[l], height[r]);

            res = Math.max(res, curWidth * lowHeight);

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return res;
    }
}
