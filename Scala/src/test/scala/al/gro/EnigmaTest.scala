package al.gro

import al.gro.codingame.Enigma
import org.scalatest.funsuite.AnyFunSuite

class EnigmaTest extends AnyFunSuite {
		val rotors: List[String] = List("BDFHJLCPRTXVZNYEIWGAKMUSQO","AJDKSIRUXBLHWTMCQGZNPYFVOE",
			"EKMFLGDQVZNTOWYHXUSPAIBRCJ")
	test("should encode basic message"){
		assert("KQF" == Enigma.solve("ENCODE",4, rotors, "AAA"))
	}

	test("should encode complex message"){
		assert("ALWAURKQEQQWLRAWZHUYKVN" == Enigma.solve("ENCODE", 7, rotors, "WEATHERREPORTWINDYTODAY"))
	}

}
