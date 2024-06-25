package al.go;

import java.util.Arrays;
import java.util.List;

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
	}
}
