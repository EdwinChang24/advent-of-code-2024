package day01

import java.io.File

fun main() {
    val lines = File("i").readLines().map { it.split(' ') }
    val list1 = lines.map { it.first() }
    val list2 = lines.map { it.last() }
    println(list1.sumOf { n -> n.toInt() * list2.count { it == n } })
}
