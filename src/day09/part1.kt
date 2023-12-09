package day09

import readInput
import kotlin.math.abs

fun main() {
    readInput("Day09_part1").sumOf { history ->
        val values = history.split(" ").map { it.toInt() }
        findPredictionValue(values)
    }.also(::println)
}

fun findPredictionValue(values: List<Int>): Int {
    if (values.all { it == 0 }) return 0

    // [1, 2, 3, 4, 5] => [ [1, 2], [2, 3], [3, 4], [4, 5]]
    val steps = values.windowed(2, 1).map { it[1] - it[0] }
    val prediction = findPredictionValue(steps)
    return values.last() + prediction
}