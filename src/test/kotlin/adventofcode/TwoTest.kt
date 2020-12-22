package adventofcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

internal class TwoTest {

    private val input = File("src/test/resources/2-input.txt")
    private val input2 = File("src/test/resources/2-input-1.txt")

    @Test
    fun test() {
        assertEquals(2, Two().solveA(input))
    }

    @Test
    fun b() {
        assertEquals(1, Two().solveB(input))
    }

    @Test
    fun `kun en av dem skal inneholdet tegnet`() {
        assertEquals(0, Two().solveB(input2))
    }
}