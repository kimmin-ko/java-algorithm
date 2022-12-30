package algorithm.leetcode.algorithm.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidPalindromeTest {

    @ParameterizedTest
    @CsvSource(value = {
            ".,:true",
            "A man, a plan, a canal: Panama:true",
            "race a car:false",
            "0P:false"
    }, delimiter = ':')
    void test(String s, boolean expected) {
        ValidPalindrome solution = new ValidPalindrome();
        boolean actual = solution.isPalindrome(s);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            ".,:true",
            "A man, a plan, a canal: Panama:true",
            "race a car:false",
            "0P:false"
    }, delimiter = ':')
    void test2(String s, boolean expected) {
        ValidPalindrome solution = new ValidPalindrome();
        boolean actual = solution.isPalindrome2(s);
        Assertions.assertEquals(expected, actual);
    }

}