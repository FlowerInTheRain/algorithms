package al.go.codewars;

public class CompArraysSquaredInts {
	public static boolean comp(int[] a, int[] b) {
		if(a == null || b == null){
			return false;
		}
		if(a.length != b.length){
			return false;
		}
		int countSquare = 0;
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < b.length; j++){
				if(a[i] * a[i] == b[j]){
					countSquare++;
					b[j] = 0;
					break;
				}
			}
		}
		return countSquare == a.length;
	}
}
