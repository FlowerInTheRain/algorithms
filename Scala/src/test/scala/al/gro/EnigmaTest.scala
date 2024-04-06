package al.gro

import al.gro.codingame.Enigma
import org.scalatest.funsuite.AnyFunSuite

class EnigmaTest extends AnyFunSuite {

	test("should encode basic message"){
		assert("KQF" == Enigma.solve("ENCODE",4, List("BDFHJLCPRTXVZNYEIWGAKMUSQO","AJDKSIRUXBLHWTMCQGZNPYFVOE",
			"EKMFLGDQVZNTOWYHXUSPAIBRCJ"), "AAA"))
	}

}
