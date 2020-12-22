package adventofcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

internal class ThreeKtTest {

    private val input = File("src/test/resources/3-input.txt")
        .readLines()

    @Test
    fun slopeTest() {
        val oofs1 = drive(input, 1, 1)
        val oofs2 = drive(input, 3, 1)
        val oofs3 = drive(input, 5, 1)
        val oofs4 = drive(input, 7, 1)
        val oofs5 = drive(input, 1, 2)

        assertEquals(336, oofs1 * oofs2 * oofs3 * oofs4 * oofs5)
    }
}