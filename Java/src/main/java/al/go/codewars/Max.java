package al.go.codewars;


public class Max {
	public static int sequence(int[] arr) {
		int seq = 0, max = 0;
		for (int i : arr) {
			seq = Math.max(0, seq + i);
			max = Math.max(max, seq);
		}
		return max;
	}
}
