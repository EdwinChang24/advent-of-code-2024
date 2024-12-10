package day05

import java.io.File

fun main() {
    val (rules, updates) = File("i").readText().split("\n\n").map { it.split("\n") }
    val validUpdates = updates.filter { update ->
        update != "" && update.split(",").run {
            rules.all { rule ->
                rule.split("|").let { indexOf(it[0]) < (indexOf(it[1]).takeIf { i -> i != -1 } ?: size) }
            }
        }
    }
    println(validUpdates.sumOf { it.split(",").run { this[size / 2].toInt() } })
}
