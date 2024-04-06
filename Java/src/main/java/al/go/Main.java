package al.go;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		List<Integer> test = Arrays.asList(1,2,2,2);
		List<Integer> taMere = List.of();
		System.out.println(test.containsAll(taMere));
		/** group chars by 2 in an array of Strongs */
		String s = "abcdefghijklmaer";
		for(int j = 0; j < 1000000; j++ ) {
			if (s.length() % 2 == 1) s += "_";
			int n = s.length() / 2;
			double sqrt=Math.sqrt(258740043);
			String[] sub = new String[n];
			for (int i = 0; i < n; ++i)
				sub[i] = "" + s.charAt(i * 2) + s.charAt(1 + i * 2);
		}
		
		/**
		 *
		 */
	}
}
