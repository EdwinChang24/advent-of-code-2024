package day08

import java.io.File

fun main() {
    val grid = File("i").readLines()
    val frequencies = grid.joinToString("").toSet().filter { it != '.' }
    val anti = mutableSetOf<Pair<Int, Int>>()
    frequencies.forEach { f ->
        val antennas = grid.mapIndexed { index, line ->
            line.mapIndexed { cIndex, c -> if (c == f) index to cIndex else null }.filterNotNull()
        }.flatten()
        antennas.forEach { antenna1 ->
            antennas.forEach { antenna2 ->
                if (antenna1 != antenna2) {
                    anti += antenna1.first * 2 - antenna2.first to antenna1.second * 2 - antenna2.second
                    anti += antenna2.first * 2 - antenna1.first to antenna2.second * 2 - antenna1.second
                }
            }
        }
    }
    println(anti.filter { it.first in grid.indices && it.second in grid[0].indices }.size)
}
