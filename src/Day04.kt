import kotlin.math.max
import kotlin.math.min

fun main() {

    fun part1(input: List<String>): Int {
        val firstSplit = input.map { it.split(",") }

        val secondSplit = firstSplit.map { it.map { it.split("-") } }.map { it.map { it.map { it.toInt() } } }

        val ranges = secondSplit.map { it.map { IntRange(it.first(), it.last()) } }

        return ranges.sumOf { it.first().overlapsFully(it.last()).toInt() }
    }

    fun part2(input: List<String>): Int {
        val firstSplit = input.map { it.split(",") }

        val secondSplit = firstSplit.map { it.map { it.split("-") } }.map { it.map { it.map { it.toInt() } } }

        val ranges = secondSplit.map { it.map { IntRange(it.first(), it.last()) } }

        return ranges.sumOf { it.first().overlapsPartially(it.last()).toInt() }
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))

}

fun Boolean.toInt(): Int {
    return if (this) 1 else 0
}

fun IntRange.overlapsFully(other: IntRange): Boolean {
    val resultRange = IntRange(max(this.first, other.first), min(this.last, other.last))

    return if (resultRange.first <= resultRange.last) {
        //overlap
        resultRange == this || resultRange == other
    } else {
        //no overlap
        false
    }
}

fun IntRange.overlapsPartially(other: IntRange): Boolean {
    return (this intersect other).isNotEmpty()
}