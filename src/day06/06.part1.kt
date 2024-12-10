package day06

import java.io.File

fun main() {
    val grid = File("i").readLines().map { it.toMutableList() }.toMutableList()
    var (row, col) = grid.indexOfFirst { '^' in it } to grid.first { '^' in it }.indexOf('^')
    grid[row][col] = 'X'
    var direction = -1 to 0
    while (true) {
        if (grid.getOrElse(row + direction.first) { mutableListOf() }
                .getOrElse(col + direction.second) { '.' } == '#') direction = when (direction) {
            -1 to 0 -> 0 to 1
            0 to 1 -> 1 to 0
            1 to 0 -> 0 to -1
            else -> -1 to 0
        }
        row += direction.first
        col += direction.second
        if (row !in grid.indices || col !in grid[0].indices) break
        grid[row][col] = 'X'
    }
    println(grid.sumOf { it.count { c -> c == 'X' } })
}
