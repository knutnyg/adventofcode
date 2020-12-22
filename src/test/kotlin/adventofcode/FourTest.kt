package adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

class FourTest {

    private val valid = File("src/test/resources/4-input-valid.txt")
    private val invalid = File("src/test/resources/4-input-invalid.txt")

    @Test
    fun `kan splitte i pass`() {
        assertEquals(4, valid.passports().size)
        assertEquals(4, invalid.passports().size)
    }

    @Test
    fun test() {
        assertEquals(4, Four(true).solve(valid))
        assertEquals(0, Four(true).solve(invalid))
    }

    @Test
    fun range() {
        assertEquals(11, (0..10).toList().size)
        assertTrue("1920".toInt() in 1920..2020 )
    }
}