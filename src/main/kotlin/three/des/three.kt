package three.des

import java.io.File

fun main() {
    val input = File("src/main/kotlin/three/des/input.txt")
        .readLines()

    var count = 0
    var horizontalPosition = 0
    input.forEachIndexed { index, line ->

        horizontalPosition = if (index != 0) {
            (horizontalPosition + 3) % (line.length)
        } else horizontalPosition

        if (line[horizontalPosition] == '#') {
            println("$index. " + line.replaceRange(horizontalPosition, horizontalPosition+1, "X"))
            count += 1
        } else {
            println("$index. " + line.replaceRange(horizontalPosition, horizontalPosition+1, "O"))
        }

    }


    println("You hit $count trees")
}
