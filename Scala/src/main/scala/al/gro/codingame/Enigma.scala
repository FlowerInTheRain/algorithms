package al.gro.codingame

import scala.annotation.tailrec

object Enigma {
	def solve(operation: String, firstShift:Int,rotors:List[String], msg:String) : String ={
		val alphabet = List('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
			'W','X','Y','Z')
		val res = operation match {
			case "ENCODE" => encode(firstShift, alphabet, rotors, msg)
			case _ => decode(firstShift, alphabet, rotors.reverse, msg)
		}
		res match {
			case Right(_) => "Invalid input"
			case Left(str)=> str
		}
	}
	@tailrec
	private def encode(firstShift:Int, alphabet:List[Char], rotors: List[String], msg:String) : Either[String, Int] = {
		if(rotors.isEmpty){
			Left(msg)
		} else {
			if(firstShift > -1){
				val msgAfterShift = msg
					.toList
					.zipWithIndex
					.map( charWithIndex => alphabet((alphabet.indexOf(charWithIndex._1) +	firstShift  + charWithIndex._2 )% alphabet.length))
					.mkString("")
				encode(-1, alphabet, rotors, msgAfterShift)
			} else {
				rotors.headOption match {
					case None => Right(0)
					case Some(str) =>
						val rotorToCharArray =  str.toList
						val msgAfterRotor = msg.toList.map(char => {
							rotorToCharArray(char.toInt - 65)
						}).mkString("")
						encode(firstShift, alphabet, rotors.drop(1), msgAfterRotor)
				}
			}
		}


	}
	@tailrec
	private def decode(firstShift:Int, alphabet:List[Char], rotors: List[String], msg:String) : Either[String, Int] = {
		if(rotors.isEmpty){

			val msgAfterShift = msg
				.toList
				.zipWithIndex
				.map( charWithIndex => {
					println(alphabet.toString)
					println(charWithIndex._1)

					println((alphabet.indexOf(charWithIndex._1) -	firstShift  - charWithIndex
						._2) % alphabet.length)
					alphabet(Math.abs((alphabet.indexOf(charWithIndex._1) -	firstShift  - charWithIndex
						._2 )% alphabet.length))
				})
				.mkString("")
			Left(msgAfterShift)
		} else {
				rotors.headOption match {
					case None => Right(0)
					case Some(str) =>
						val rotorToCharArray =  str.toList
						val msgAfterRotor = msg.toList.map(char => {
							alphabet(rotorToCharArray.indexOf(char))
						}).mkString("")
						println(msgAfterRotor)
						decode(firstShift, alphabet, rotors.drop(1), msgAfterRotor)
				}
			}
		}
}

