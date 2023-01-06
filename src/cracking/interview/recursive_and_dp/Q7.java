package cracking.interview.recursive_and_dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q7 {

    public static void main(String[] args) {
        ArrayList<String> permutations = getPerms("abcdefg");
        System.out.println("permutations = " + permutations);
        System.out.println(permutations.size());
    }

    static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }
        return permutations;
    }

    static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

}
