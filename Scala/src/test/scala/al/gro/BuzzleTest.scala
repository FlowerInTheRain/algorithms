package al.gro

import al.gro.codingame.BuzzleObj
import org.scalatest.funsuite.AnyFunSuite

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

        val solved1 = BuzzleObj.solve("10 107 114", "7")
        assert(solved1 == answer1)
        val solved2 = BuzzleObj.solve("10 26 40", "7")
        assert(solved2 == answer2)
    }
    test("base 18 buzzle with 2 keys should be solved") {

        val answer4: List[String] = List(
          "1029",
          "1030",
          "Buzzle",
          "1032",
          "1033",
          "Buzzle",
          "1035",
          "1036",
          "Buzzle",
          "1038",
          "1039",
          "1040",
          "1041",
          "Buzzle",
          "Buzzle",
          "1044",
          "Buzzle",
          "1046",
          "1047",
          "Buzzle",
          "1049",
          "1050",
          "1051",
          "1052",
          "1053",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "1057",
          "1058",
          "Buzzle",
          "1060",
          "Buzzle",
          "1062",
          "1063",
          "1064",
          "Buzzle",
          "1066",
          "Buzzle",
          "1068",
          "1069",
          "1070",
          "Buzzle",
          "1072",
          "Buzzle",
          "1074",
          "1075",
          "Buzzle",
          "1077",
          "Buzzle",
          "Buzzle",
          "1080",
          "1081",
          "Buzzle",
          "1083",
          "1084",
          "1085",
          "1086",
          "1087",
          "Buzzle"
        )
        val solved4 = BuzzleObj.solve("18 1029 1088", "11 17")
        assert(solved4 == answer4)
    }

    test("Everything is Buzzle") {

        val answer4: List[String] = List(
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle",
          "Buzzle"
        )
        val solved = BuzzleObj.solve("6 128 144", "3 4 5")
        assert(solved == answer4)
    }
}
