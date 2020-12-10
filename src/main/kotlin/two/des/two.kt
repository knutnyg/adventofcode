package two.des

import java.io.File

fun main() {
    val count = File("src/main/kotlin/two/des/input.txt")
            .readLines()
            .map {
                val splitt = it.split(":")
                Pair(splitt.first(), splitt.last().trim())
            }.filter {
                val min = it.first.split("-").first().toInt()
                val max = it.first.split("-").last().split(" ").first().toInt()
                val char = it.first.split(" ").last().first()

                println("$min, $max, $char")
                val count = it.second.chars().filter { it == char.toInt() }.count()
                (count in min..max)
            }
            .count()
    println(count)

}
