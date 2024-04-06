package al.go.esgi.training;

import java.util.stream.IntStream;

public class StringCompressionCanalPlus {
    public static String compressOccurrence(String toCompress){
        if(toCompress == null || toCompress.isEmpty() || toCompress.contentEquals(" ")){
            throw new RuntimeException("Invalid source data");
        }
        IntStream.range(1,9).filter(i -> i%3==0 || i%5 ==0).sum();
        toCompress = toCompress.replaceAll(" ","");
        StringBuilder compressedString = new StringBuilder();
        int occurrences = 0;
        char character = toCompress.charAt(0);
        for(int i = 1; i < toCompress.length(); i++){
            if(toCompress.charAt(i) == character){
                occurrences++;
            } else {
                compressedString.append(character);
                insertOccurrences(compressedString, occurrences);
                occurrences = 0;
                character = toCompress.charAt(i);
            }
        }
        compressedString.append(character);
        insertOccurrences(compressedString, occurrences);
        return compressedString.toString();
    }

    private static void insertOccurrences(StringBuilder compressesString, int occurrences) {
        if(occurrences > 0){
            compressesString.append(occurrences);
        }
    }
}