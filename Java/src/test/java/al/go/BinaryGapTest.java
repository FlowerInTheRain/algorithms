package al.go;

import al.go.codility.BinaryGap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BinaryGapTest {
    @ParameterizedTest
    @CsvSource({
            "529,4",
            "32,0",
            "20,1",
            "8,0"
    })
    public void shouldFindLongestBinaryGap(int toTest, int expectedOutput){
        int answer = BinaryGap.solution(toTest);
        Assertions.assertEquals(expectedOutput, answer);
    }
}
