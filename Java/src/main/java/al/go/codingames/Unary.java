package al.go.codingames;

public class Unary {
    public static String unaryRepresentation(String MESSAGE) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = getCharsAsArray(MESSAGE);
        for(int j = 0; j < charArray.length; j++){
            builder.append('0');
            if(charArray[j] == '1'){
                builder.append(' ');
                for(int k = j  ; k < charArray.length; k++){
                    if(charArray[k] == '1'){
                        builder.append('0');
                        if(k +1 == charArray.length) {
                            j = k +1;
                            break;
                        }
                    } else {j = k - 1;break;}
                }
            } else {
                builder.append('0');
                builder.append(' ');
                for(int l = j; l < charArray.length; l++){
                    if(charArray[l] == '0'){
                        builder.append('0');
                        if(l + 1 == charArray.length) {
                            j = l+1;
                            break;
                        }
                    } else {j = l - 1;break;}
                }
            }
            if(j < charArray.length - 1) builder.append(' ');
        }
        return builder.toString();
    }
    
    private static char[] getCharsAsArray(String MESSAGE) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        char[] charArray = MESSAGE.toCharArray();
        for (char c : charArray) {
            String binaryString = Integer.toBinaryString(c);
            if (binaryString.length() < 7) {
                int step = (7 - (binaryString.length() % 7));
                for (int j = 0; j < step; j++) {
                    binaryStringBuilder.insert(binaryStringBuilder.toString().length(), "0");
                }
            }
            binaryStringBuilder.append(binaryString);
        }
        charArray = binaryStringBuilder.toString().toCharArray();
        return charArray;
    }
}

