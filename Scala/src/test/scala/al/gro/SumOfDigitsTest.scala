package al.gro

import al.gro.codewars.SumOfDigits
import org.scalatest.funsuite.AnyFunSuite

class SumOfDigitsTest extends AnyFunSuite {

	test("should find sum of digits"){
		assert(0 == SumOfDigits.digitalRoot(0))
		assert(6 == SumOfDigits.digitalRoot(6))
		assert(8 == SumOfDigits.digitalRoot(17))
		assert(6 == SumOfDigits.digitalRoot(456))
	}
}
