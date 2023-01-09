package algorithm.leetcode.string;

public class RotateString {

    public static void main(String[] args) {

    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        s = s + s;
        int goalHash = goal.hashCode();
        for (int i = 0; i < s.length() - goal.length() + 1; i++) {
            String substring = s.substring(i, i + goal.length());
            if (substring.hashCode() == goalHash && substring.equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
