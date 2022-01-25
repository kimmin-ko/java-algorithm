package algorithm.section.string;

import java.util.Scanner;

public class 대소문자_변환_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c <= 90) sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }

        return sb.toString();
    }

}
