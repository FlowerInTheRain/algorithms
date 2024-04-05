package al.gro

import scala.annotation.tailrec

object LightBulbs {
	def solve(input:String, target:String):Int = {
		if(input.equals(target)){
			0
		} else {
			if (target.last == '0') {
				lastInputVerifier(input, target,'I')
			} else {
				lastInputVerifier(input, target,'0')

			}
		}

	}

	private def lastInputVerifier(input: String, target: String,newChar:Char): Int = {
		if (target.last != input.last) {
			checkAllRemainingChars(1, input.init, target.init, newChar)

		} else {
			checkAllRemainingChars(0, input.init, target.init, target.last)
		}
	}

	@tailrec
	private def checkAllRemainingChars(counter: Int, init: String, init1: String, last:Char) :Int = {
		println()
		if(init.isEmpty){
			counter
		} else {
			if(init.last != init1.last){
				if(last == '0'){
					checkAllRemainingChars(counter + 1, init.init, init1.init, '1')

				} else {
					if(init.length() == 1){
						checkAllRemainingChars(counter + 1, init.init, init1.init, last)

					} else {
						checkAllRemainingChars(counter + 2, init.init, init1.init, last)

					}
				}

			} else {
				checkAllRemainingChars(counter, init.init, init1.init, last)
			}
		}
	}
	/**
	private def buildNewString(input: String, indexToModify:Int, newChat:Char):String ={
		input.toCharArray.update(indexToModify, newChat).toString
	}
	*/
}
