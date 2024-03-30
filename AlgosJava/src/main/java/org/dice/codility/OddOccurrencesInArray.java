package org.dice.codility;

public class OddOccurrencesInArray {

    public static int solution(int[] array){
        int res = 0;
        for (int i : array) {
            System.out.println("res " + Integer.toBinaryString(res));
            res ^= i;

            System.out.println("i   "+ Integer.toBinaryString(res));
        }

        return res;
    }
}
