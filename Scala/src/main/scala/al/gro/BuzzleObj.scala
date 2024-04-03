package al.gro

import al.gro.BaseConverter.convertFromAnyBaseToDecimal

import scala.annotation.tailrec

object BuzzleObj {
    def solve(firstLine: String, modulos: String): List[String] = {
        val Array(n, a, b): Array[Int] = (firstLine split " ").filter(_ != "").map(_.toInt)
        val inputs: Array[String] = modulos split " "
        def solveInRange(current: Int, end: Int): List[String] = {
            if (current > end) List()
            else {
                val num: String = current.toString
                val result = checkNumber(num, inputs, n)
                result :: solveInRange(current + 1, end)
            }
        }
        solveInRange(a, b)
    }
    @tailrec
    private def recursiveSumOfDigits(num: Int, input: String, validator: Int, base: Int): Boolean = {
        if (input.length <= 1) {
            false
        } else {
            val res: Int = input.split("").map(x => convertFromAnyBaseToDecimal(x, base)).sum
            if (res % validator == 0 || convertFromAnyBaseToDecimal(Integer.toString(res, base).last.toString, base) == validator) {
                true
            } else {
                recursiveSumOfDigits(num, Integer.toString(res,base), validator, base)
            }
        }
    }

    private def checkNumber(num: String, inputs: Array[String], base: Int): String = {
        inputs.map(modulo => {
            num.toInt % modulo.toInt == 0 ||
                convertFromAnyBaseToDecimal(Integer.toString(num.toInt, base).last.toString, base) == modulo.toInt ||
                recursiveSumOfDigits(num.toInt, Integer.toString(num.toInt, base), modulo.toInt, base)
        }
        ).find(res => res) match {
            case Some(_) =>
                // println("Buzzle")
                "Buzzle"
            case None =>
                //println(num)
                num
        }
    }
}
