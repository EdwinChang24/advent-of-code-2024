package day04

import java.io.File

fun main() {
    val xmas = listOf("XMAS", "SAMX")
    val grid = File("i").readLines()
    val horizontals = grid.sumOf { it.windowed(4).count { s -> s in xmas } }
    val verticals =
        grid[0].indices.sumOf { grid.map { l -> l[it] }.joinToString("").windowed(4).count { s -> s in xmas } }
    val upright = (0..(grid.size + grid[0].length)).sumOf { i ->
        grid.indices.map {
            grid.getOrElse(it) { "" }.getOrElse(i - it) { ' ' }
        }.joinToString("").windowed(4).count { s -> s in xmas }
    }
    val downright = (-grid[0].length..grid.size).sumOf { i ->
        grid.indices.map {
            grid.getOrElse(it + i) { "" }.getOrElse(it) { ' ' }
        }.joinToString("").windowed(4).count { s -> s in xmas }
    }
    println(horizontals + verticals + upright + downright)
}
