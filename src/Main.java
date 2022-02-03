import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = solution(n);
        System.out.println(answer);
    }

    static int solution(int n) {
        int answer = 0;

        boolean[] primeNumbers = new boolean[n + 1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for (int i = 2; (i * i) <= n; i++) {
            if (primeNumbers[i]) {
                for (int j = (i * i); j <= n; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        for (boolean primeNumber : primeNumbers) {
            if (primeNumber)
                answer++;
        }

        return answer;
    }

}