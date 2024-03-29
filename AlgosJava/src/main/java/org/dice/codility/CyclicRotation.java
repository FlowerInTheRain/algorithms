package org.dice.codility;

public class CyclicRotation {
    public static int[] solution(int[] A, int K){
        if(A.length <= 1){
            return A;
        }
        int[] newArray = new int[A.length];
        for(int i = 0; i < A.length; i ++){
            newArray[((K+i)%A.length)] = A[i];
        }
        return newArray;
    }
}
