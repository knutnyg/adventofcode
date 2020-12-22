package adventofcode

import CalendarPuzzle
import java.io.File

class Four(debug: Boolean = false) : CalendarPuzzle(debug) {

    private val requiredFields = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")

    fun solve(input: File = File("src/main/resources/4-input.txt")): Int {
        val count = input
            .passports()
            .toKeyValue()
            .valid(requiredFields)
            .count()
        println("4: Svar på A: $count")
        return count
    }
}

fun List<List<Pair<String, String>>>.valid(requiredFields: List<String>): List<List<Pair<String, String>>> {
    return this.filter {
        it.map { it.first }.containsAll(requiredFields)
    }
}

fun List<String>.toKeyValue() = this.map { passport ->
    passport
        .split(" ")
        .map {
            val parts = it.split(":")
            parts.first() to parts.last()
        }
}

fun File.passports() =
    this.readText()
        .split("\n\n")
        .map { it.replace("\n", " ") }
