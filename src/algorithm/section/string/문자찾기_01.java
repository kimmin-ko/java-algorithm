package algorithm.section.string;

import java.util.Scanner;

public class 문자찾기_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String c = scanner.next();
        int result = solution(str, c);
        System.out.println(result);
    }

    static int solution(String str, String c) {
        int count = 0;
        c = c.toLowerCase();

        String[] strs = str.toLowerCase().split("");
        int s = 0;
        int e = strs.length - 1;

        while (s <= e) {
            if (s == e) {
                count++;
                break;
            }

            if (strs[s].equals(c)) count++;
            if (strs[e].equals(c)) count++;

            s++;
            e--;
        }

        return count;
    }

}
