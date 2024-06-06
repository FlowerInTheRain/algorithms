package al.gro

import al.gro.codewars.Narcissistic
import org.scalatest.funsuite.AnyFunSuite

class NarcissisticTest extends AnyFunSuite {
    test("should find narcissistic numbers") {
        assert(true, Narcissistic.solve(7))
        assert(true, Narcissistic.solve(371))
    }

    test("should not find narcissistic numbers") {
        assert(true, Narcissistic.solve(122))
        assert(true, Narcissistic.solve(4887))
    }
}
