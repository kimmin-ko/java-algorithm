package algorithm.section.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 큰_수_출력하기_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] intArr = new int[count];
        for (int i = 0; i < count; i++) {
            intArr[i] = scanner.nextInt();
        }
        List<Integer> results = solution(intArr);
        for (Integer result : results) {
            System.out.print(result + " ");
        }
    }

    static List<Integer> solution(int[] arr) {
        List<Integer> results = new ArrayList<>();
        results.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                results.add(arr[i]);
            }
        }
        return results;
    }
}
