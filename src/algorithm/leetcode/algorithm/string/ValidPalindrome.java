package algorithm.leetcode.algorithm.string;

public class ValidPalindrome {

    public boolean isPalindrome2(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left <= right) {
            while (!isAlphanumeric(chars[left])) {
                if (left >= right) {
                    return true;
                }
                left++;
            }
            while (!isAlphanumeric(chars[right])) {
                if (right <= left) {
                    return true;
                }
                right--;
            }

            if (chars[left] != chars[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        boolean isAlphabet = 97 <= c && c <= 122;
        boolean isNumeric = 48 <= c && c <= 57;
        return isAlphabet || isNumeric;
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().replaceAll("[^a-z|0-9]", "").toCharArray();

        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
