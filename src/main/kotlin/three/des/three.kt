package three.des

import java.io.File

val input = File("src/main/kotlin/three/des/input.txt")
    .readLines()

fun main() {
    val oofs1 = drive(input, 1, 1)
    val oofs2 = drive(input, 3, 1)
    val oofs3 = drive(input, 5, 1)
    val oofs4 = drive(input, 7, 1)
    val oofs5 = drive(input, 1, 2)

    println("You hit $oofs1 * $oofs2 * $oofs3 * $oofs4 * $oofs5 = ${oofs1*oofs2*oofs3*oofs4*oofs5} trees")
}

internal fun drive(
    map: List<String>,
    slopeX: Int,
    slopeY: Int,
): Long {
    var i = slopeX * -1
    var j = 0
    var count = 0L
    while (j < map.size) {
        i = (i + slopeX) % map.first().length
        val line = map[j]
        if (line[i] == '#') {
            println("$j. " + line.replaceRange(i, i + 1, "X"))
            count += 1
        } else {
            println("$j. " + line.replaceRange(i, i + 1, "O"))
        }
        j += slopeY
    }
    return count
}
