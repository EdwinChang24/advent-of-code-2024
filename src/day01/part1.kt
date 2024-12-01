package day01

import java.io.File
import kotlin.math.abs

fun main() {
    val lines = File("i").readLines().map { it.split(' ') }
    val list1 = lines.map { it.first() }.sorted()
    val list2 = lines.map { it.last() }.sorted()
    var total = 0
    repeat(lines.size) { total += abs(list1[it].toInt() - list2[it].toInt()) }
    println(total)
}
