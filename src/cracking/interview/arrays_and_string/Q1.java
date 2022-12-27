package cracking.interview.arrays_and_string;

import java.util.Arrays;
import java.util.HashSet;

public class Q1 {

    public static void main(String[] args) {
        boolean r1 = isUniqueCharsForAscii("Aabcdz");
        System.out.println(r1);

        boolean r2 = isUniqueChars("안녕하세요. 안");
        System.out.println(r2);

        boolean r3 = isUniqueCharsNoDataStructure("안녕하세요");
        System.out.println(r3);
    }

    // 입력 값이 ASCII 코드일 경우
    static boolean isUniqueCharsForAscii(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] uniqueStrStorage = new boolean[128];
        for (char c : str.toCharArray()) {
            if (uniqueStrStorage[c]) {
                return false;
            }
            uniqueStrStorage[c] = true;
        }
        return true;
    }

    // 입력 값이 유니코드일 경우
    static boolean isUniqueChars(String str) {
        HashSet<Character> chars = new HashSet<>(str.length());
        for (char c : str.toCharArray()) {
            if (chars.contains(c)) {
                return true;
            }
            chars.add(c);
        }
        return false;
    }

    // 브루트포스를 사용할 경우 O(n^2)
    // 입력 값을 정렬할 수 있고 자료구조를 사용하지 않을 경우 O(n log(n))
    static boolean isUniqueCharsNoDataStructure(String str) {
        char[] sortedChars = str.toCharArray();
        Arrays.sort(sortedChars);

        for (int i = 0; i < sortedChars.length - 1; i++) {
            if (sortedChars[i] == sortedChars[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
