package algorithm.section.twopointerslidingwindow;

import java.util.Scanner;

public class 최대_매출 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int solution = solution(a, k);
        System.out.println(solution);
    }

    static int solution(int[] a, int k) {
        int answer = 0;

        for (int i = 0; i < k; i++)
            answer += a[i];

        int sum = answer;
        for (int i = 0, j = k; j < a.length; i++, j++) {
            sum += a[j] - a[i];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

}
