package algorithm.section.twopointerslidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 공통원소_구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = scanner.nextInt();

        List<Integer> answers = solution(a, b);
        answers.forEach(answer -> System.out.print(answer + " "));
    }

    static List<Integer> solution(int[] a, int[] b) {
        List<Integer> answers = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int p1 = 0;
        int p2 = 0;

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] == b[p2]) {
                answers.add(a[p1]);
                p1++;
                p2++;
            } else if (a[p1] < b[p2])
                p1++;
            else
                p2++;
        }

        return answers;
    }

}
