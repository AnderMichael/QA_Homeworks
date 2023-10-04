package practice1UnitTests.exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class BancoTest {
    private static ASFIService service;
    private static Banco banco;

    @BeforeAll
    public static void setValues() {
        service = Mockito.mock(ASFIService.class);
        banco = new Banco();
        banco.setAsfiService(service);
    }
    @ParameterizedTest
    @CsvSource({
            "454566, A, Maximo a prestar 200000",
            "999999, B, Maximo a prestar 100000",
            "777777, C, No se puede prestar ningún monto ALERTA!",
            "111111, D, ERROR - Categoría inexistente!",
            "\"\",\"\" , ERROR - Categoría inexistente!"

    })
    public void checkCategories(String ci, String category, String expectedResult) {
        Mockito.when(service.getCategoria(ci)).thenReturn(category);
        String currentResult = banco.getMaximoPrestamo(ci);
        Assertions.assertEquals(expectedResult, currentResult, "ERROR: There is no coincidence with the expected and current result!");
        Mockito.verify(service).getCategoria(ci);
    }

    @Test
    public void verifyNull() {
        Mockito.when(service.getCategoria(null)).thenReturn(null);
        Assertions.assertThrows(Exception.class, () -> {
            banco.getMaximoPrestamo(null);
        }, "There is no way to set a Null value as a ci");
    }
}
