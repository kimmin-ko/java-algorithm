package cracking.interview.arrays_and_string;

import java.util.Arrays;

public class Q2 {

    public static void main(String[] args) {
        System.out.println(permutationForAsciiCode("ABC ", " BCF"));
        System.out.println(permutationForAsciiCode("ABC ", " BCA"));

        System.out.println(permutation("A BC", "CB A"));
        System.out.println(permutation("A BC", "CB C"));
    }

    private static boolean permutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return sort(a).equals(sort(b));
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // 문자열이 ASCII 코드일 경우
    private static boolean permutationForAsciiCode(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] count = new int[128];
        for (char c : a.toCharArray()) {
            count[c]++;
        }
        for (char c : b.toCharArray()) {
            count[c]--;
            if (count[c] < 0) {
                return false;
            }
        }
        return true;
    }

}
