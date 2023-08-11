fun main() {

    fun part1(input: List<String>): Int {
        input.joinToString("")
            .windowed(4, 1)
            .forEachIndexed { index, strings ->
                if (strings.toSet().size == 4) return index + 4
            }
        return 0
    }

    fun part2(input: List<String>): Int {
        input.joinToString("")
            .windowed(14, 1)
            .forEachIndexed { index, strings ->
                if (strings.toSet().size == 14) return index + 14
            }
        return 0
    }

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}