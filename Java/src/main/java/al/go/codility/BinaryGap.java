package al.go.codility;

public class BinaryGap {
    public static int solution(int number){
        final String numToBinaryString = Integer.toBinaryString(number);
        int binaryGap = 0;
        int occurrences = 0;
        int indexStart = numToBinaryString.indexOf("1");
        if(indexStart == (numToBinaryString.length() - 1)){
            return binaryGap;
        }
        for(int i = indexStart + 1; i < numToBinaryString.length(); i++){
            if(numToBinaryString.charAt(i) != '0'){
                if(occurrences > binaryGap && i > indexStart) {
                    binaryGap = occurrences;
                    indexStart = i;
                }
                occurrences = 0;
            } else {
                occurrences++;
            }
        }
        return binaryGap;
    }
}
