package al.go;

import al.go.codewars.Likes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LikesTest {
	private final String[] names = new String[4];
	@Test
	public void shouldTestSomething(){
		names[0] = "Sid";
		names[1] = "Nono";
		names[2] = "Armand";
		names[3] = "Jojo";
		assertEquals("Sid, Nono and 2 others like this",Likes.whoLikesIt(names));
	}
}
