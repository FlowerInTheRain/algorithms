package al.go;

import al.go.codingames.Unary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

class UnaryTest {
    @ParameterizedTest
    @CsvSource(
            {
                    "C,0 0 00 0000 0 00",
                    "CC,0 0 00 0000 0 000 00 0000 0 00",
                    "%,00 0 0 0 00 00 0 0 00 0 0 0"
            }
    )
    void shouldGiveCorrectUnaryRepresentation(String input, String expectedOutput) throws IOException {
        Assertions.assertEquals(expectedOutput, Unary.unaryRepresentation(input));
    }
}
