package algorithm.section.string;

import java.util.Scanner;

public class 특정_문자_뒤집기_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }

    static String solution(String str) {
        char[] chars = str.toCharArray();

        int lt = 0;
        int rt = chars.length - 1;
        while (lt < rt) {
            if (Character.isAlphabetic(chars[lt]) && Character.isAlphabetic(chars[rt])) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            } else if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            }
        }

        return String.valueOf(chars);
    }
}
