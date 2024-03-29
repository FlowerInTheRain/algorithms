package org.dice;

import org.dice.codility.CyclicRotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CyclicRotationTest {
    public static Stream<Arguments> cyclicRotationByKeyShouldWork() {
        return Stream.of(
                Arguments.of(new int[]{3, 8, 9, 7, 6}, 3,new int[]{9, 7, 6, 3, 8}),
                Arguments.of(new int[]{3}, 3,new int[]{3})
        );
    }
    @ParameterizedTest
    @MethodSource
    public void cyclicRotationByKeyShouldWork(int[] arrayInput, int key, int[] arrayOutput){
        Assertions.assertArrayEquals(arrayOutput, CyclicRotation.solution(arrayInput, key));
    }
}
