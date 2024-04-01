package al.go.codility;

public class MinimalJump {
	
	public static int solve(int X, int Y, int D) {
		if(Y-X == 0){
			return 0;
		}
		if(D + X >= Y ){
			return 1;
			
		}
		if(((Y-X)%D)!= 0){
			return ((Y-X)/D) + 1;
			
		} else {
			return ((Y-X)/D);
			
		}
	}
}
