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
                grid.indices.forEach { row ->
                    grid[row].indices.forEach { col ->
                        if ((antenna2.first - antenna1.first).toDouble() / (antenna2.second - antenna1.second) == (antenna2.first - row).toDouble() / (antenna2.second - col)) anti += row to col
                    }
                }
            }
        }
    }
    println(anti.size)
}
