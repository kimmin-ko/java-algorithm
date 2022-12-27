package cracking.interview.arrays_and_string;

public class Q6 {

    public static void main(String[] args) {
        System.out.println(compression("aabccccaaad"));
        System.out.println(compression("abcdef"));
    }

    private static String compression(String str) {
        StringBuilder sb = new StringBuilder(str.length());

        char[] chars = str.toCharArray();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == str.length() || chars[i] != chars[i + 1]) {
                sb.append(chars[i]).append(count);
                count = 1;
                continue;
            }

            count++;
        }

        String result = sb.toString();
        return result.length() > str.length() ? str : result;
    }
}
