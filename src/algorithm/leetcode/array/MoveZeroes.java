package algorithm.leetcode.array;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes s = new MoveZeroes();
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
//        s.moveZeroes(nums);
        s.moveZeroes2(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }

    public void moveZeroes2(int[] nums) {
        int wIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[wIdx] = nums[i];
                wIdx++;
            }
        }

        while (wIdx < nums.length) {
            nums[wIdx++] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int zeroPointer = 0;
        int nonZeroPointer = 0;
        while (nonZeroPointer < nums.length) {
            while (zeroPointer < nums.length && nums[zeroPointer] != 0) {
                zeroPointer++;
            }
            nonZeroPointer = zeroPointer + 1;
            while (nonZeroPointer < nums.length && nums[nonZeroPointer] == 0) {
                nonZeroPointer++;
            }

            if (nonZeroPointer >= nums.length || zeroPointer >= nums.length) {
                return;
            }

            swap(nums, zeroPointer, nonZeroPointer);
            zeroPointer++;
            nonZeroPointer++;
        }
    }

    private void swap(int[] nums, int zeroPointer, int nonZeroPointer) {
        int temp = nums[zeroPointer];
        nums[zeroPointer] = nums[nonZeroPointer];
        nums[nonZeroPointer] = temp;
    }
}
