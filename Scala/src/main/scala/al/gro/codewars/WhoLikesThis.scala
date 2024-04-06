package al.gro.codewars

object WhoLikesThis {
	@SuppressWarnings(Array("org.wartremover.warts.StringPlusAny"))
	def solve(names:Array[String]):String = {
		names.length match {
			case 0 => "no one likes this"
			case 1 => names(0) + " likes this"
			case 2 => names(0) + " and " + names(1) + " like this"
			case 3 => names(0) + ", " + names(1) + " and " + names(2) + " like this"
			case _ => names(0) + ", " + names(1) + " and " + (names.length - 2) +" others like this"
		}
	}

}
