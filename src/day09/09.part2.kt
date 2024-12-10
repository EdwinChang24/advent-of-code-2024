package day09

import java.io.File

fun main() {
    val input = File("i").readLines()[0]
    val (files, spaces) = input.runningFoldIndexed<Pair<Pair<Int, Int>, Int?>>(0 to 0 to null) { index, acc, c -> acc.first.first + acc.first.second to c.digitToInt() to if (index % 2 == 0) index / 2 else null }
        .partition { it.second != null }
        .let { it.first.map { i -> i.first to i.second!! } to it.second.map { p -> p.first } }
    val buckets = spaces.map { it.first to it.second to mutableListOf<Pair<Int, Int>>() }
    val unmoved = mutableListOf<Pair<Pair<Int, Int>, Int>>()
    files.reversed().forEach { file ->
        buckets.firstOrNull { it.first.first < file.first.first && it.first.second - it.second.sumOf { i -> i.first } >= file.first.second }?.second?.add(
            file.first.second to file.second
        ) ?: unmoved.add(file).also { println(file) }
    }
    println(buckets.sumOf { bucket ->
        bucket.second.fold(bucket.first.first to 0L) { acc, p -> acc.first + p.first to acc.second + (acc.first.toLong()..<acc.first.toLong() + p.first).sum() * p.second }.second
    } + unmoved.sumOf { file ->
        (file.first.first.toLong()..<file.first.first.toLong() + file.first.second).sum() * file.second
    })
}
