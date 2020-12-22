package adventofcode

import java.io.File

class Two(val debug: Boolean = false) {
    private fun triple(it: Pair<String, String>): Triple<Int, Int, Char> {
        val first = it.first.split("-").first().toInt()
        val second = it.first.split("-").last().split(" ").first().toInt()
        val char = it.first.split(" ").last().first()
        return Triple(first, second, char)
    }

    fun solve() {
        val a = solveA()
        val b = solveB()

        println("2: Svaret på A: $a, og B: $b")
    }

    fun solveA(input: File = File("src/main/resources/2-input.txt")): Int {
        return input
            .readLines()
            .map {
                val splitt = it.split(":")
                Pair(splitt.first(), splitt.last().trim())
            }.filter {
                val (min, max, char) = triple(it)
                if(debug) { println("$min, $max, $char") }

                val count = it.second.chars().filter { it == char.toInt() }.count()
                (count in min..max)
            }
            .count()
    }

    fun solveB(input: File = File("src/main/resources/2-input.txt")): Int {
        return input
            .readLines()
            .map {
                val split = it.split(":")
                Pair(split.first(), split.last().trim())
            }.filter {
                val (first, second, char) = triple(it)

                if(debug) { println("$first, $second, $char") }
                (it.second[first-1] == char).xor(it.second[second-1] == char)
            }
            .count()
    }
}
