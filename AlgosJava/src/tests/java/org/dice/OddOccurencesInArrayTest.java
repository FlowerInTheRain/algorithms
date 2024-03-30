package org.dice;

import org.dice.codility.OddOccurrencesInArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class OddOccurencesInArrayTest {

    public static Stream<Arguments> oddOccurrences() {
        return Stream.of(
                Arguments.of(new int[]{9,3,9,3,9,7,9}, 7),
                Arguments.of(new int[]{1,2,2,1,1,1}, 0),
                Arguments.of(new int[]{9,3,9,3,9,7,9,9,3,9,3,9,9,9,3,9,3,9,9}, 7)
                );
    }
    @ParameterizedTest
    @MethodSource
    public void oddOccurrences(int[] array, int result){
        Assertions.assertEquals(result, OddOccurrencesInArray.solution(array));
    }
}
