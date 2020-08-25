import kotlin.test.assertEquals

/**reverse string*/
class Task1 {

    companion object {

        fun simpleReverse(str: String): String = str.reversed()

        fun cycledReverse(str: String): String {
            var result = ""
            str.forEach { c ->
                result = "$c$result"
            }
            return result
        }
    }
}

/**count number of specified letter and return Int calculated by formula*/
class Task2 {

    companion object {

        fun countLetters(str: String): Int = with(str) {
            var result = getNumberOfLetter("a")
            result *= getNumberOfLetter("drtf")
            result += getNumberOfLetter("e")
            result *= getNumberOfLetter("lm")
            result -= getNumberOfLetter(" ")
            result *= getNumberOfLetter("a")
            result += getNumberOfLetter("lm")
            result
        }

        /**     extension function to count chars in string */
        private fun String.getNumberOfLetter(cs: CharSequence): Int {
            var result = 0
            return with(this) {
                forEach { c ->
                    result += cs.count { it == c }
                }
                result
            }
        }

    }
    /**
    Calculation to correct:
     * result = number of 'a' - 1
     * number of 'd' or 'r' or 't' or 'f' - 3
    + number of 'e' - 1
     * number of 'l' or 'm' -4
    - number of ' ' - 2
     * number of 'a' - 1
    + number of 'l' or 'm'- 4
    "five dollar bill" -> 1 * 3 + 1 * 4 - 2 * 1 + 4 = 18
     */
}

fun main() {
    assertEquals("elpmaxe", Task1.simpleReverse("example"))
    assertEquals("elpmaxe", Task1.cycledReverse("example"))

    assertEquals(18, Task2.countLetters("five dollar bill"))
}
