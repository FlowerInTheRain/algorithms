package al.gro

object Main {
  def main(args: Array[String]): Unit = {
    var i = 88;
    for(n <- 0 to i.toString.length){
     i =i.toString().split("").map(_.toInt).sum

    }
    println(i)

  }
}