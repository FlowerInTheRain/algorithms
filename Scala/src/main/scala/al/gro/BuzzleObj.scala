package al.gro

import scala.annotation.tailrec
import scala.util.control.Breaks
import scala.util.control.Breaks.break

object BuzzleObj {
	def solve(firstLine: String, k: String, modulos: String): List[String] = {
		var answers:List[String] = List()
		val Array(n, a, b) = (firstLine split " ").filter(_ != "").map(_.toInt)
		val inputs = modulos split " "
		for (i <- a to b) {
			val num = Integer.toString(i,n)
			var isPrinted = false
			for (j <- 0 until inputs.length) {
				if (num.toInt % inputs(j).toInt == 0 || num.endsWith(inputs(j))) {

					answers :+= "Buzzle"
					println("Buzzle")
					isPrinted = true
				} else if (recursiveSumOfDigits(num.toInt, inputs(j).toInt)) {
					answers :+= "Buzzle"
					println("Buzzle")
					isPrinted = true
				}
			}
			if (!isPrinted) {
				answers :+= num
				println(num)
				isPrinted = false
			}
		}
		answers
	}

	@tailrec
	private def recursiveSumOfDigits(input: Int, validator: Int): Boolean = {
		val res = input.toString.split("").map(x => x.toInt).sum
		if (res % validator == 0 || res.toString.endsWith(validator.toString)) {
			 true
		} else {
			if (res.toString.length <= 1) {
				false;
			} else {
				recursiveSumOfDigits(res, validator)
			}
		}
	}

}
