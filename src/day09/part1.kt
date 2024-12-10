package day09

import java.io.File

fun main() {
    val input = File("i").readLines()[0]
    val fs = input.mapIndexed { index, c -> List(c.digitToInt()) { if (index % 2 == 0) index / 2 else null } }.flatten()
        .toMutableList()
    for (i in fs.indices) {
        if (fs[i] != null) continue
        while (fs.last() == null) fs.removeLast()
        if (fs.lastIndex < i) break
        fs[i] = fs.last()
        fs[fs.lastIndex] = null
    }
    println(fs.mapIndexed { index, i -> index.toLong() * (i ?: 0) }.sum())
}
