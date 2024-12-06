package day06

import java.io.File

fun main() {
    val grid = File("i").readLines().map { it.toMutableList() }.toMutableList()
    var total = 0
    for (obsRow in grid.indices) {
        for (obsCol in grid[obsRow].indices) {
            if (grid[obsRow][obsCol] in setOf('#', '^')) continue
            grid[obsRow][obsCol] = '#'
            val visited = mutableSetOf<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
            val (startRow, startCol) = grid.indexOfFirst { '^' in it } to grid.first { '^' in it }.indexOf('^')
            var (row, col) = startRow to startCol
            grid[row][col] = '.'
            var direction = -1 to 0
            while (true) {
                if (row to col to direction in visited) {
                    total++
                    break
                }
                visited += row to col to direction
                while (grid.getOrElse(row + direction.first) { mutableListOf() }.getOrElse(col + direction.second) { '.' } == '#') {
                    direction = when (direction) {
                        -1 to 0 -> 0 to 1
                        0 to 1 -> 1 to 0
                        1 to 0 -> 0 to -1
                        else -> -1 to 0
                    }
                }
                row += direction.first
                col += direction.second
                if (row !in grid.indices || col !in grid[0].indices) break
            }
            grid[startRow][startCol] = '^'
            grid[obsRow][obsCol] = '.'
        }
    }
    println(total)
}
