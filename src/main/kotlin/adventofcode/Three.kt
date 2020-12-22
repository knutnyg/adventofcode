package adventofcode

import java.io.File


class Three(debug: Boolean = false) {
    companion object {
        private val input = File("src/main/resources/3-input.txt")
            .readLines()

        fun solve() {
            val oofs1 = drive(input, 1, 1)
            val oofs2 = drive(input, 3, 1)
            val oofs3 = drive(input, 5, 1)
            val oofs4 = drive(input, 7, 1)
            val oofs5 = drive(input, 1, 2)

            val product = oofs1 * oofs2 * oofs3 * oofs4 * oofs5
            println("3: Svaret på A: $oofs2 og B: $product")
        }
    }
}

internal fun drive(
    map: List<String>,
    slopeX: Int,
    slopeY: Int,
    debug: Boolean = false
): Long {
    var i = slopeX * -1
    var j = 0
    var count = 0L
    while (j < map.size) {
        i = (i + slopeX) % map.first().length
        val line = map[j]
        if (line[i] == '#') {
            if (debug) {
                println("$j. " + line.replaceRange(i, i + 1, "X"))
            }
            count += 1
        } else {
            if (debug) {
                println("$j. " + line.replaceRange(i, i + 1, "O"))
            }
        }
        j += slopeY
    }
    return count
}
