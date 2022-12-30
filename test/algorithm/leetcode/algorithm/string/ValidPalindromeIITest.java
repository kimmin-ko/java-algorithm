package algorithm.leetcode.algorithm.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeIITest {


    @ParameterizedTest
    @CsvSource(value = {
            "aba:true",
            "abca:true",
            "abc:false",
            "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga:true",
            "ebcbbececabbacecbbcbe:true"
    }, delimiter = ':')
    void test(String s, boolean expected) {
        ValidPalindromeII solution = new ValidPalindromeII();
        boolean actual = solution.validPalindrome(s);
        Assertions.assertEquals(expected, actual);
    }
}