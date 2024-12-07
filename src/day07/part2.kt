package day07

import java.io.File
import kotlin.math.pow
import kotlin.math.roundToLong

fun main() {
    val equations = File("i").readLines()
        .map { it.split(": ").run { get(0).toLong() to get(1).split(" ").map { n -> n.toLong() } } }
    println(equations.filter { equation ->
        (0..<3.0.pow(equation.second.size - 1).roundToLong()).any {
            equation.second.reduceIndexed { index, acc, l ->
                when (it.toString(3).padStart(equation.second.size - 1)[index - 1]) {
                    '1' -> acc * l
                    '2' -> "$acc$l".toLong()
                    else -> acc + l
                }
            } == equation.first
        }
    }.sumOf { it.first })
}
