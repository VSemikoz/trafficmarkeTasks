import kotlin.test.assertEquals

/**reverse string*/
class Task1 {

    companion object {

        fun simpleReverse(str: String): String = str.reversed()

        fun cycledReverse(str: String): String {
            var reversedString = ""
            str.forEach { c ->
                reversedString = "$c$reversedString"
            }
            return reversedString
        }
    }
}

/**count number of specified letter and return Int calculated by formula*/
class Task2 {

    companion object {

        fun countLetters(str: String): Int = with(str) {
            var counter = getNumberOfLetter("a")
            counter *= getNumberOfLetter("drtf")
            counter += getNumberOfLetter("e")
            counter *= getNumberOfLetter("lm")
            counter -= getNumberOfLetter(" ")
            counter *= getNumberOfLetter("a")
            counter += getNumberOfLetter("lm")
            counter
        }

        /**     extension function to count chars in string */
        private fun String.getNumberOfLetter(cs: CharSequence): Int {
            var countOfLetters = 0
            return with(this) {
                forEach { c ->
                    countOfLetters += cs.count { it == c }
                }
                countOfLetters
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
