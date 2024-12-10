package day04

import java.io.File

fun main() {
    val grid = File("i").readLines()
    val a = grid.mapIndexed { index, l -> l.indices.filter { l[it] == 'A' }.map { index to it } }.flatten()
    println(a.count {
        listOf(
            grid.getOrElse(it.first - 1) { "" }.getOrElse(it.second - 1) { ' ' },
            grid.getOrElse(it.first - 1) { "" }.getOrElse(it.second + 1) { ' ' },
            grid.getOrElse(it.first + 1) { "" }.getOrElse(it.second + 1) { ' ' },
            grid.getOrElse(it.first + 1) { "" }
                .getOrElse(it.second - 1) { ' ' }).joinToString("") in "MMSSSMMSSSMMMSSM".chunked(4)
    })
}
