package al.gro.codewars

import scala.annotation.tailrec

object SumOfDigits {
    @tailrec
    def digitalRoot(n: Int): Int = {
        n < 10 match {
            case true => n
            case false =>
                digitalRoot(n.toString.split("").map(x => x.toInt).sum)
        }
    }

}
