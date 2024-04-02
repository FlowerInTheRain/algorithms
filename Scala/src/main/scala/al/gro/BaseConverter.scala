package al.gro

@SuppressWarnings(
  Array("org.wartremover.warts.Var", "org.wartremover.warts.Return")
)
object BaseConverter {
    def convertFromAnyBaseToDecimal(num: String, base: Int): Int = {
        if (base < 2 || base > 36) {
            -1
        } else {
            var `val`: Int = 0
            var power: Int = 1
            for (i <- num.length - 1 to 0 by -1) {
                val digit: Int = charToDecimal(num.charAt(i))
                if (digit < 0 || digit >= base) {
                    return -1
                }
                `val` += digit * power
                power *= base
            }
            `val`
        }
    }

    private def charToDecimal(c: Char): Int = {
        if (c >= '0' && c <= '9') {
            c - '0'
        } else if (c >= 'A' && c <= 'Z') {
            c - 'A' + 10
        } else if (c >= 'a' && c <= 'z') {
            c - 'a' + 10
        } else {
            -1
        }
    }
}
