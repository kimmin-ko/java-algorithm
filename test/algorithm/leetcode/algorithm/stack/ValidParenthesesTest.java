package algorithm.leetcode.algorithm.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidParenthesesTest {

    @ParameterizedTest
    @CsvSource(value = {
            "()[]{}:true",
            "(]:false",
            "))):false",
            "(((:false"
    }, delimiter = ':')
    void test(String s, boolean expected) {
        ValidParentheses solution = new ValidParentheses();
        boolean actual = solution.isValid(s);
        Assertions.assertEquals(actual, expected);
    }

}