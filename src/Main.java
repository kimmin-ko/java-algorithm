import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

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

        return null;
    }

}