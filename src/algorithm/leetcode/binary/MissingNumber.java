package algorithm.leetcode.binary;

public class MissingNumber {

//    public int missingNumber(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        for (int i = 0; i <= n; i++) {
//            if (i == n || i != nums[i]) {
//                return i;
//            }
//        }
//        return 0;
//    }

    public int missingNumber(int[] nums) {
        int missingNumber = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingNumber = missingNumber ^ i ^ nums[i]; // a ^ b ^ b = a
        }
        return missingNumber;
    }
}
