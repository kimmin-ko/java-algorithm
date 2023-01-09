package cracking.interview.arrays_and_string;

import java.util.Arrays;
import java.util.HashSet;

public class Q1 {

    public static void main(String[] args) {
        boolean r1 = isUniqueCharsForAscii("Aabcdza");
        System.out.println(r1);

        boolean r2 = isUniqueChars("안녕하세요. 안");
        System.out.println(r2);

        boolean r3 = isUniqueCharsNoDataStructure("안녕하세요안");
        System.out.println(r3);
    }

    // 입력 값이 ASCII 코드일 경우
    // 시간 복잡도: O(n)
    // 공간 복잡도: O(1)
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
    // 시간 복잡도: O(n)
    // 공간 복잡도: O(n)
    static boolean isUniqueChars(String str) {
        HashSet<Character> chars = new HashSet<>(str.length());
        for (char c : str.toCharArray()) {
            if (chars.contains(c)) {
                return false;
            }
            chars.add(c);
        }
        return true;
    }

    // 입력 값을 정렬할 수 있고 자료구조를 사용하지 않을 경우
    // 시간 복잡도: O(n log(n))-> n log n
    // 공간 복잡도: O(n)
    static boolean isUniqueCharsNoDataStructure(String str) {
        // 자료구조를 사용하진 않았지만 정렬하기 위한 추가적인 공간이 필요하다.
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
