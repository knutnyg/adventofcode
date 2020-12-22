import adventofcode.Four
import adventofcode.One
import adventofcode.Three
import adventofcode.Two

fun main() {
    One().solve()
    Two().solve()
    Three.solve()
    Four().solve()
}


abstract class CalendarPuzzle(private val debug:Boolean = false) {
    fun printd(text:Any) {
        if(debug) { println(text) }
    }
}