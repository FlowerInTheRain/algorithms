package al.go.codility;

public class OddOccurrencesInArray {

    public static int solution(int[] array){
        int res = 0;
        for (int i : array) {
            res ^= i;
        }

        return res;
    }
}
