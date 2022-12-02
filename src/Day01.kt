fun main() {

    fun part1(input: List<String>): Int {
        val caloriesPerElf = input.getCaloriesPerElfAsList()
        return caloriesPerElf.max()
    }

    fun part2(input: List<String>): Int {
        val caloriesPerElf = input.getCaloriesPerElfAsList()
        return caloriesPerElf
            .asSequence()
            .sortedDescending()
            .take(3)
            .sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

fun List<String>.getCaloriesPerElfAsList(): List<Int> {
    var currentSum = 0
    val caloriesPerElf: MutableList<Int> = mutableListOf()

    for (line in this) {
        if (line == "") {
            caloriesPerElf.add(currentSum)
            currentSum = 0
        } else {
            currentSum += line.toInt()
        }
    }
    caloriesPerElf.add(currentSum)

    return caloriesPerElf.toList()
}