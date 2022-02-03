package algorithm.section.array;

import java.util.Scanner;

public class 가위_바위_보_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = scanner.nextInt();

        String answer = solution(a, b);
        System.out.println(answer);
    }

    static String solution(int[] a, int[] b) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < a.length; i++)
            answer.append(rockPaperScissors(a[i], b[i])).append("\n");

        return answer.toString();
    }

    static String rockPaperScissors(int a, int b) {
        if (a == b)
            return "D";
        else if ((a == 1 && b == 2) || (a == 2 && b == 3) || (a == 3 && b == 1))
            return "B";
        else
            return "A";
    }
}
