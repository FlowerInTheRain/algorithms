package al.go;

import al.go.codingames.AsciiArt;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AsciiArtTest {
	private final List<String> answer1 =  Arrays.asList(
			"### ",
			"#   ",
			"##  ",
			"#   ",
			"### ");
	private final List<String> answer4 =  Arrays.asList(
			"# # ### ### # # ### ### ### ### ### ",
			"###   # # # # #   #  #   #    # # # ",
			"###  ## # # ###  ##  #   #   ## # # ",
			"# #     # # # #      #   #      # # ",
			"# #  #  # # # #  #   #   #   #  # # ");
	
	final List<String> fourWidth5Height = (" #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   " +
												  "## ### " +
											"# # # # " +
								 "# # # # # # ### ### \n" +
								 "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # \n" +
								 "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## \n" +
								 "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       \n" +
								 "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##  " +
								 " #  ###  #  # # # #  #  ###  #  ").lines().toList();
	@Test
	public void shouldDisplayAnE(){
		assertTrue(answer1.containsAll(AsciiArt.solve(4, 5, "E",fourWidth5Height)));
	}
	
	@Test
	public void shouldDisplayInterrogationPointWhenSpecialChar(){
		assertTrue(answer4.containsAll(AsciiArt.solve(4, 5, "M@NH@TT@N",fourWidth5Height)));
	}
}
