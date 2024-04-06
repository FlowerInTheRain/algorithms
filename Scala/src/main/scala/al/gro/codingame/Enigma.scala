package al.gro.codingame

import scala.annotation.tailrec

object Enigma {
	def solve(operation: String, firstShift:Int,rotors:List[String], msg:String) : String ={
		val alphabet = List('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
			'W','X','Y','Z')
		val res = operation match {
			case "ENCODE" => encode(firstShift, alphabet, rotors, msg)
			case _ => encode(firstShift, alphabet, rotors, msg)
		}
		res match {
			case Right(_) => "Unablle to do shit"
			case Left(str)=> str
		}
	}
	@tailrec
	def encode(firstShift:Int, alphabet:List[Char], rotors: List[String], msg:String) : Either[String, Int] = {
		if(rotors.isEmpty){
			Left(msg)
		} else {
			if(firstShift > -1){
				val msgAfterShift = msg.toList.zipWithIndex.map( (charWithIndex) => alphabet(alphabet.indexOf
				(charWithIndex._1) +	4  + charWithIndex._2 %
						alphabet.length))
					.mkString("")
				println(msgAfterShift)
				encode(-1, alphabet, rotors, msgAfterShift)
			} else {
				rotors.headOption match {
					case None => Right(0)
					case Some(str) =>
						val rotorToCharArray =  str.toList
						val msgAfterRotor = msg.toList.map(char => {
							println(rotorToCharArray(char.toInt - 65))
							rotorToCharArray(char.toInt - 65)
						}).mkString("")
						encode(firstShift, alphabet, rotors.drop(1), msgAfterRotor)
				}
			}
		}
	}
}

