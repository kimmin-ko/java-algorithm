package algorithm.section.twopointerslidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 두_배열_합치기_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextInt();
        }

        List<Integer> answers = solution(a, b);
        for (Integer answer : answers) {
            System.out.print(answer + " ");
        }
    }

    static List<Integer> solution(int[] a, int[] b) {
        List<Integer> answers = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] <= b[p2])
                answers.add(a[p1++]);
            else
                answers.add(b[p2++]);
        }

        while (p1 < a.length)
            answers.add(a[p1++]);

        while (p2 < b.length)
            answers.add(b[p2++]);

        return answers;
    }

}
