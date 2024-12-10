package day02

import java.io.File

fun main() {
    val lines = File("i").readLines().map { it.split(' ').map(String::toInt) }
    val count = lines.count { report ->
        ("$report" == "${report.sorted()}" || "$report" == "${report.sortedDescending()}")
            && report.sorted().windowed(2).all { it[1] - it[0] in 1..3 }
    }
    println(count)
}
