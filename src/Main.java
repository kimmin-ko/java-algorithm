import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }

    static String solution(String str) {
        String[] arr = str.split(" ");
        String answer = arr[0];

        for (int i = 1; i < arr.length; i++)
            if (arr[i].length() > answer.length())
                answer = arr[i];

        return answer;
    }

}