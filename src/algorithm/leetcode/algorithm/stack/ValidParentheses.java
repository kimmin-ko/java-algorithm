package algorithm.leetcode.algorithm.stack;

import java.util.Map;

public class ValidParentheses {

    public boolean isValid(String s) {
        int top = -1;
        char[] stack = new char[s.length()];

        for (char bracket : s.toCharArray()) {
            System.out.println(bracket);
            if (Brackets.isOpen(bracket)) {
                top++;
                stack[top] = bracket;
                continue;
            }

            // 닫힌 괄호인데 스택이 비어있으면 false
            if (top < 0) {
                return false;
            }

            if (Brackets.isPair(stack[top], bracket)) {
                // 닫힌 괄호인데 짝이 맞으면 top 제거
                stack[top] = '\u0000';
                top--;
            } else {
                // 닫힌 괄호인데 짝이 안맞으면 false
                return false;
            }
        }

        return top < 0;
    }

    static class Brackets {
        private static final Map<Character, Character> openClosePair = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );

        public static boolean isPair(char open, char close) {
            return openClosePair.get(open) == close;
        }

        public static boolean isOpen(char bracket) {
            return openClosePair.containsKey(bracket);
        }
    }

}
