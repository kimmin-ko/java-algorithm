package algorithm.section.string;

import java.util.Scanner;

public class 단어_뒤집기_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++)
            sb.append(solution(scanner.nextLine())).append("\n");

        System.out.println(sb);
    }

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--)
            sb.append(str.charAt(i));

        return sb.toString();
    }

}
