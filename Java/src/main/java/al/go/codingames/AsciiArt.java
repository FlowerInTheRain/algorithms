package al.go.codingames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsciiArt {
	public static List<String> solve(int width, int height, String input,List<String> lines){
		char[] stringToArrayChar = input.toCharArray();
		List<String> toReturn = new ArrayList<>();
		for(int j = 0; j < height; j++){
			String ROW = lines.get(j);
			StringBuilder toAdd = new StringBuilder();
			for (char c : stringToArrayChar) {
				if (((int) c) >= 65 && ((int) c) <= 90) {
					int toInt = (((int) c) - 65) * width;
					toAdd.append(ROW, toInt, toInt + width);
				} else if (((int) c) >= 97 && ((int) c) <= 122) {
					int toInt = (((int) c) - 97) * width;
					toAdd.append(ROW, toInt, toInt + width);
				} else {
					toAdd.append(ROW.substring(ROW.length() - width));
				}
				
			}
			toReturn.add(toAdd.toString());
		}
		return toReturn;
	}
}
