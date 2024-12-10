package day10

import java.io.File

fun main() {
    val grid = File("i").readLines()
    println(grid.flatMapIndexed { index, row -> row.indices.filter { row[it] == '0' }.map { index to it } }
        .sumOf { coords ->
            fun find(c: Pair<Int, Int>): Set<Pair<Int, Int>> = listOf(
                c.first - 1 to c.second, c.first + 1 to c.second, c.first to c.second - 1, c.first to c.second + 1
            ).filter {
                it.first in grid.indices && it.second in grid[0].indices && grid[it.first][it.second].digitToInt() == grid[c.first][c.second].digitToInt() + 1
            }.flatMap { if (grid[it.first][it.second] == '9') listOf(it) else find(it) }.toSet()
            find(coords).size
        })
}
