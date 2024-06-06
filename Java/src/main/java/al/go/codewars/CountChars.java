package al.go.codewars;

import java.util.HashMap;
import java.util.Map;

public class CountChars {
	public static Map<Character, Integer> count(String str) {
		if (str.isEmpty()) {
			return new HashMap<>();
		}
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : str.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		return map;
	}
}
