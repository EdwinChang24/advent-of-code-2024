package day05

import java.io.File

fun main() {
    val (rules, updates) = File("i").readText().split("\n\n").map { it.split("\n") }
    val sortedUpdates = updates.filter { it != "" }.map { update ->
        update.split(",").sortedWith { o1, o2 -> if ("$o1|$o2" in rules) -1 else 1 }
    }
    println(updates.mapIndexed { index, update ->
        if (update != "" && update.split(",") != sortedUpdates[index]) sortedUpdates[index].run { this[size / 2].toInt() } else 0
    }.sum())
}
