package al.go;

import java.util.Arrays;
import java.util.List;
<<<<<<< Updated upstream
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		List<Integer> test = Arrays.asList(1,2,2,2);
		List<Integer> taMere = List.of();
		System.out.println(test.containsAll(taMere));
		/** group chars by 2 in an array of Strings */
		String s = "abcdefghijklmaer";
		for(int j = 0; j < 1000000; j++ ) {
			if (s.length() % 2 == 1) s += "_";
			int n = s.length() / 2;
			String[] sub = new String[n];
			for (int i = 0; i < n; ++i)
				sub[i] = "" + s.charAt(i * 2) + s.charAt(1 + i * 2);
		}
		System.out.println(IntStream.range(2,3).filter(n -> 3%n == 0).count());
=======
import java.util.concurrent.atomic.AtomicReference;

public class Main {
	public static void main(String[] args) {
		int[] input = {3, -7, 9, -11, -4, 3, 3, 3};
		List<Integer> test = Arrays.stream(input).boxed().toList();
        var even = test.stream().takeWhile(item -> Math.abs(item) % 2 == 0).toList();
        var odd = test.stream().takeWhile(item -> Math.abs(item) % 2 == 1).toList();
        if(odd.size() < even.size()){
            System.out.println(test.get(even.size()));
        } else {
            System.out.println(test.get(odd.size()));
        }
>>>>>>> Stashed changes
	}
}
