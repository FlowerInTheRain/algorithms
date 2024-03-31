package al.go;

import al.go.codility.OddOccurrencesInArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class OddOccurrencesInArrayTest {



    public static Stream<Arguments> testFindCorrectResultOddOccurrences() {
        return Stream.of(
                Arguments.of(new int[]{9,3,9,3,9,7,9}, 7),
                Arguments.of(new int[]{1,2,2,1,1,1}, 0),
                Arguments.of(new int[]{9,3,9,3,9,7,9,9,3,9,3,9,9,9,3,9,3,9,9}, 7)
                );
    }

    /**
     * @param array an array of ints with one odd number or not
     * @param result the expected result from the method, 0 if no odd occurrence, or the odd occurence
     */
    @ParameterizedTest
    @MethodSource
    public void testFindCorrectResultOddOccurrences(int[] array, int result){
        Assertions.assertEquals(result, OddOccurrencesInArray.solution(array));
    }
}
