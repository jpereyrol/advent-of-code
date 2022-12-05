fun main() {

    fun part1(input: List<String>): Int {
        val chunkedInput = input.map { it.chunked(it.length / 2) }

        val intersects = chunkedInput.map {
            it.first().toCharArray() intersect it.last().toSet()
        }

        return intersects.sumOf { it.first().toPriority() }
    }

    fun part2(input: List<String>): Int {
        val chunkedInput = input.chunked(3)

        val intersects = chunkedInput.map { (first, second, third) ->
            first.toSet() intersect second.toSet() intersect third.toSet()
        }

        return intersects.sumOf { it.first().toPriority() }
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))

}

fun Char.toPriority(): Int {
    return if (this.isUpperCase()) {
        this.code - 'A'.code + 27
    } else {
        this.code - 'a'.code + 1
    }
}