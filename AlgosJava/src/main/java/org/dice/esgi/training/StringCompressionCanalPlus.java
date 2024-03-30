package org.dice.esgi.training;

public class StringCompressionCanalPlus {
    public static int test1 = 7;

    public static String compressOccurrence(String toCompress){
        int test = 2;
        if(toCompress == null || toCompress.isEmpty() || toCompress.contentEquals(" ")){
            throw new RuntimeException("Invalid source data");
        }
        toCompress = toCompress.replace(" ","" + test1);
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