package al.go;

import al.go.esgi.training.StringCompressionCanalPlus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCompressionCanalPlusTests {

    @ParameterizedTest
    @CsvSource({
           "sssdbbbbbb,s2db5",
            "s,s",
            "salut,salut",
            "Sous la houlle de soisson,Souslahoul1edesois1on",
            "zzzzzzzzzzzzzpppOOOOO, z12p2O4"
    })
    public void testStringCompressionShouldReturnCorrectCompressedString(String input, String expectedOutput){
        String result = StringCompressionCanalPlus.compressOccurrence(input);
        Assertions.assertEquals(result, expectedOutput);
    }
    @ParameterizedTest
    @NullSource    // pass a null value
    @ValueSource(strings = {"", " "})
    public void testStringCompressionShouldThrowRuntimeException(String input){
        Assertions.assertThrows(RuntimeException.class,() -> StringCompressionCanalPlus.compressOccurrence(input) );
    }
}
