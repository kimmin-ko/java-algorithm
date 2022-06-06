import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();

        int solution = solution(a, m);
        System.out.println(solution);
    }

    static int solution(int[] a, int m) {
        int answer = 0;

        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < a.length; rt++) {
            sum += a[rt];
            if (sum == m)
                answer++;

            while (sum >= m) {
                sum -= a[lt++];
                if (sum == m)
                    answer++;
            }
        }

        return answer;
    }

}