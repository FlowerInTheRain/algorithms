package al.gro

import al.gro.codewars.WhoLikesThis
import org.scalatest.funsuite.AnyFunSuite

class WhoLikesThisTest extends AnyFunSuite{

	test("should find correct sentence for 5 likes") {
		assert("Nono, Sid and 4 others like this" == WhoLikesThis.solve(Array("Nono", "Sid","Jojo", "Armand",
			"Nadjet","Arthur")))
	}

}
