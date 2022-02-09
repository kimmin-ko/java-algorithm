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

        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < a.length && bIdx < b.length) {
            if (a[aIdx] <= b[bIdx]) {
                answers.add(a[aIdx]);
                aIdx++;
            } else {
                answers.add(b[bIdx]);
                bIdx++;
            }
        }

        if (aIdx != a.length) {
            for (int i = aIdx; i < a.length; i++) {
                answers.add(a[i]);
            }
        } else {
            for (int i = bIdx; i < b.length; i++) {
                answers.add(b[i]);
            }
        }

        return answers;
    }

}
