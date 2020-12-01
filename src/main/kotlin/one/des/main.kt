package one.des

import java.io.File

fun main() {
    val input = File("src/main/kotlin/one/des/input.txt")
            .readLines()
            .map(String::toInt)

    input.forEach loop@{ a ->
        input.forEach { b ->
            if (a + b == 2020) {
                println("$a + $b = 2020")
                println(a * b)
                return@loop
            }
        }
    }

    input.forEach loop@{ a ->
        input.forEach { b ->
            input.forEach { c ->
                if (a + b + c == 2020) {
                    println("$a + $b + $c = 2020")
                    return@loop
                }
            }
        }
    }
}
