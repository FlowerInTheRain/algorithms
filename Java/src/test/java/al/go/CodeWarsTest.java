package al.go;

import al.go.codewars.CompArraysSquaredInts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CodeWarsTest {
	@Test
	void CompArraysSquaredInts(){
		int[] array1 = new int[]{1,2,3,4,5,6,7,8,9,10}, array2 = new int[]{1*1,2*2,3*3,4*4,5*5,6*6,7*7,8*8,9*9,10*10};
		Assertions.assertTrue(CompArraysSquaredInts.comp(array1, array2));
		int[] array3 = new int[]{122,243,35454,412,55, 55 ,612,787}, array4 = new int[]{
				787*787, 122*122,243*243,35454*35454,412*412,55*55, 55*55 ,612*612
		};
		Assertions.assertTrue(CompArraysSquaredInts.comp(array3, array4));
	}
}
