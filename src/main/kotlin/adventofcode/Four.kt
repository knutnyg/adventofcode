package adventofcode

import CalendarPuzzle
import java.io.File

class ValidatablePair(val first: String, val second: String, private val validate: (String) -> Boolean?) {
    fun isValid(): Boolean = validate(second) ?: true
}

val rules = mapOf(
    "byr" to { str -> str.length == 4 && str.toInt() in 1920..2002 },
    "iyr" to { str -> str.length == 4 && str.toInt() in 2010..2020 },
    "eyr" to { str -> str.length == 4 && str.toInt() in 2020..2030 },
    "hgt" to ::hgt,
    "hcl" to ::hcl,
    "ecl" to { str -> listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(str) },
    "pid" to { str -> str.length == 9 && str.toInt() in 0..999999999 }
)

fun hcl(str: String): Boolean =
    str.first() == '#' &&
            str.split('#').drop(1).first().length == 6 &&
            str.drop(1).all { it in '0'..'9' || it in 'a'..'f' }

fun hgt(str: String): Boolean =
    when {
        str.contains("cm") -> {
            val num = str.split("cm").first()
            num.toInt() in 150..193
        }
        str.contains("in") -> {
            val num = str.split("in").first()
            num.toInt() in 59..76
        }
        else -> false
    }


class Four(debug: Boolean = false) : CalendarPuzzle(debug) {
    fun solve(input: File = File("src/main/resources/4-input.txt")): Int {
        val pairs = input
            .passports()
            .map { passport -> passport.toValidatablePair() }

        val a = pairs.filter { it.containsAllKeys() }
        val b = a.filter { it.all { pair -> pair.isValid() } }

        println("Svaret på A: ${a.count()} og B:${b.count()}")
        return b.count()
    }
}

fun List<List<Pair<String, String>>>.valid(requiredFields: List<String>): List<List<Pair<String, String>>> {
    return this.filter {
        it.map { it.first }.containsAll(requiredFields)
    }
}

fun List<ValidatablePair>.containsAllKeys(): Boolean = this.map { it.first }.containsAll(rules.keys)

fun String.toValidatablePair(): List<ValidatablePair> =
    this
        .split(" ")
        .map {
            val parts = it.split(":")
            ValidatablePair(parts.first(), parts.last(), rules.getOrDefault(parts.first()) { true })
        }

fun File.passports() =
    this.readText()
        .split("\n\n")
        .map { it.replace("\n", " ") }
