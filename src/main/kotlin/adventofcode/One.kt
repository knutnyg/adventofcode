package adventofcode

import java.io.File

class One(val debug: Boolean = false) {
    private val input = File("src/main/resources/1-input.txt")
        .readLines()
        .map(String::toInt)

    fun solve() {
        val a = solveA()
        val b = solveB()
        println("1: Svaret på A: $a, og B: $b")
    }

    private fun solveA(): Pair<Int, Int>? {
        input.forEach loop@{ a ->
            input.forEach { b ->
                if (a + b == 2020) {
                    return a to b
                }
            }
        }
        return null
    }

    private fun solveB(): Triple<Int, Int, Int>? {
        input.forEach loop@{ a ->
            input.forEach { b ->
                input.forEach { c ->
                    if (a + b + c == 2020) {
                        return Triple(a,b,c)
                    }
                }
            }
        }
        return null
    }
}
