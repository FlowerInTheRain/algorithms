package al.gro

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import al.gro.BaseConverter.convertFromAnyBaseToDecimal

class BuzzleTest extends AnyFunSuite {
    test("base 10 buzzle with single key should be solved") {
        val answer1: List[String] = List(
          "Buzzle",
          "108",
          "109",
          "110",
          "111",
          "Buzzle",
          "113",
          "114"
        )
        val answer2: List[String] = List(
          "26",
          "Buzzle",
          "Buzzle",
          "29",
          "30",
          "31",
          "32",
          "33",
          "Buzzle",
          "Buzzle",
          "36",
          "Buzzle",
          "38",
          "39",
          "40"
        )
        var solved = BuzzleObj.solve("10 107 114", "1", "7")
        assert(answer1 == solved)
        solved = BuzzleObj.solve("10 26 40", "1", "7")
        assert(answer2 == solved)
    }
}
