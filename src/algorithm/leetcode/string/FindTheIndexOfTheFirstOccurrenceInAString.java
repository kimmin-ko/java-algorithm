package algorithm.leetcode.string;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        int answer = strStr("sadbutsad", "sad");
        System.out.println("answer = " + answer);
    }

    public static int strStr(String haystack, String needle) {
        int needleHash = needle.hashCode();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String substring = haystack.substring(i, i + needle.length());
            if (substring.hashCode() == needleHash && needle.equals(substring)) {
                return i;
            }
        }
        return -1;
    }

}
