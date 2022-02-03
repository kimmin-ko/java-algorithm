package algorithm.section.array;

import java.util.Scanner;

public class 보이는_학생_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int[] arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = solution(arr);
        System.out.println(result);
    }

    static int solution(int[] arr) {
        int result = 1;
        int max = arr[0];

        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max) {
                result++;
                max = arr[i];
            }

        return result;
    }
}
