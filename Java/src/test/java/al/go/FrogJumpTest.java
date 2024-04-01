package al.go;

import al.go.codility.MinimalJump;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class FrogJumpTest {
	@ParameterizedTest
	@CsvSource({
			"10,85,30, 3",
			"10,55,43,2",
			"10,55,45, 1",
			"10,22,3, 4",
			"120,3500,4,845",
	})
	public void shouldFindMinimalFrogJumps(int x, int y, int D, int expectedOutput){
		int answer = MinimalJump.solve(x, y, D);
		Assertions.assertEquals(expectedOutput, answer);
	}
}
