package al.gro

object Narcissistic {
	def solve(n: Int): Boolean = n.toString.split("").map(c => Math.pow(c.toDouble, n.toString.length.toDouble)).sum == n

}
