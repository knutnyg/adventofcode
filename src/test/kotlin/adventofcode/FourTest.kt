package adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

class FourTest {

    private val input = File("src/test/resources/4-input.txt")

    @Test
    fun `kan splitte i pass`() {
        assertEquals(4, input.passports().size)
    }

    @Test
    fun `kan splitte i key value`() {
        assertEquals(listOf(listOf(Pair("eyr", "gry"))), listOf("eyr:gry").toKeyValue())
    }

    @Test
    fun `filterer bort invalid`() {
        assertTrue(listOf(listOf(Pair("eyr", "gry"))).valid(listOf("eyr", "vg")).isEmpty())
    }

    @Test
    fun `filterer ikke bort gyldig`() {
        assertTrue(listOf(listOf(Pair("eyr", "gry"))).valid(listOf("eyr")).isNotEmpty())
        assertTrue(listOf(listOf("eyr" to "gry", "arf" to "#123")).valid(listOf("eyr", "arf")).isNotEmpty())
    }

    @Test
    fun test() {
       assertEquals(2, Four(true).solve(input))
    }
}