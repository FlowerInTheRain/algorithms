package al.gro

object Main {
    @SuppressWarnings(Array("org.wartremover.warts.Var"))
    def main(args: Array[String]): Unit = {
        val someList1: Seq[Int] = Seq(1, 2, 2)
        val someList2: Seq[Int] = Seq()
        println(someList1.diff(someList2).toString())
        println(someList1.toList.containsSlice(someList2.toList))
        var i: Int = 88;
        for (n <- 0 to i.toString.length) {
            i = i.toString.split("").map(_.toInt).sum
            println(n)
        }
        println(i)
    }
}
