package unitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberInversorTest {
    private NumberInversor inversor;

    @BeforeAll
    public void setInversor(){
        inversor =  new NumberInversor();
    }

    // Boundary Testing
    // Los 3 primeros límite inferior

    @ParameterizedTest
    @CsvSource({
            "-1, Valor Incorrecto",
            "0, 0",
            "1, 1",

            "8, 8",
            "1234, 4321",
            "274738, 837472",

            "2147483646, 6463847412",
            "2147483647, 7463847412",
            "-2147483648, Valor Incorrecto",

    })
    public void positiveIntegerNumberVerification(int n, String expectedResult) {
        String currentResult = inversor.reverseNumber(n);
        Assertions.assertEquals(expectedResult, currentResult, "Error: There was an incorrect value in the process");
    }

    @Test
    public void testReverseNonNumericValue() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inversor.reverseNumber(Integer.parseInt("not_a_number"));
        });

        String expectedMessage = "For input string: \"not_a_number\"";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }}
