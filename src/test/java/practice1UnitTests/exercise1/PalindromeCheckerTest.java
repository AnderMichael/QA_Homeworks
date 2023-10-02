package practice1UnitTests.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PalindromeCheckerTest {

    private static PalindromeChecker palindromeChecker;

    @BeforeAll
    public static void setValues() {
        palindromeChecker = new PalindromeChecker();
    }

    @ParameterizedTest
    @CsvSource({
            "jose, false",
            "oro, true",
            "\"\",true",
            "12345654321,true",
            "1234567890, false",
            "racecar, true",
            "hello, false",
            "level, true",
            "world, false",
            "deified, true",
            "openai, false",
            "radar, true",
            "python, false",
            "2@#$@2, false"
    })
    public void checkPalindromes(String word, boolean expectedResult) {
        boolean currentResult = palindromeChecker.isPalindrome(word);
        Assertions.assertEquals(expectedResult, currentResult);
    }

    @Test
    public void nullVerification() {
        Assertions.assertThrows(Exception.class, () -> {
            palindromeChecker.isPalindrome(null);
        }, "There is no way to set a Null value as a word");
    }
}
