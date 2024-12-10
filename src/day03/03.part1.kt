package day03

import java.io.File

fun main() = println(
    File("i")
        .readText()
        .split("mul(")
        .drop(1)
        .map { it.split(")").first().split(",") }
        .filter { it.size == 2 && it[0].toIntOrNull() != null && it[1].toIntOrNull() != null }
        .sumOf { it[0].toInt() * it[1].toInt() }
)
