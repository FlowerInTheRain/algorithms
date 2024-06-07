package al.gro.codewars

object JadenCaseString {

  def main(args: Array[String]): Unit = {
    val test = "CvE"
    val separator = " "
    var res = ""
    for((letter, count) <- test.zipWithIndex) {
        res = res + letter.toUpper + (letter.toLower.toString * count)

    }
    println(test.split(" ").map(_.reverse).mkString(" "))

  }

}
