package al.gro
import scala.util.control.Breaks._

@SuppressWarnings(Array("org.wartremover.warts.Var"))
object FrogRiverSolver {
    def solve(X: Int, A: Array[Int]): Unit = {
        breakable {
            var occurrences = 0
            var index = 0
            var i = 1
            while (i <= X) {
                var j = 0
                while (j < A.length) {
                    if (A(j) == i) {
                        occurrences += 1
                        if (j > index) index = j
                        // if (occurrences == X) return j
                        break()
                    }
                    j += 1
                }
                i += 1
            }
        }
    }
}
