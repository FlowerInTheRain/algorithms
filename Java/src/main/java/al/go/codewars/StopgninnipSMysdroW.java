package al.go.codewars;

import java.util.Arrays;

public class StopgninnipSMysdroW {
	public static String spinWords(String sentence) {
		//TODO: Code stuff here
		var intoArray = sentence.split(" ");
		var res = "";
		StringBuilder builder = new StringBuilder();
		if (intoArray.length > 1){
			res = String.join(" ", Arrays.asList(intoArray).stream().map(word -> {
							if(word.length() > 5){
								return builder.append(word).reverse().toString();
							} else {
								return word;
							}
						}).toList());
		} else {
			res = builder.append(intoArray[0]).toString();
		}
		
		return res;
	}
}
