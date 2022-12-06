import java.util.*

fun main() {

    fun part1(input: List<String>): Int {
        val (moves, stacks) = input.filterNot { it == "" }.partition {
            it.contains("move")
        }

        // stacks
        val numStacks = stacks.last().last().toString().toInt()
        val stackValues = stacks.dropLast(1).reversed()

        val currentStacks = readListByColumn(stackValues, numStacks)

        //moves
        val regex = Regex("(\\d+)")

        val updatedMoves = moves.map { move ->
            regex.findAll(move).map { it.value.toInt() }.toList()
        }

        //operation
        updatedMoves.forEach { (move, from, to) ->
            for (i in 0 until move) {
                currentStacks[to - 1].push(currentStacks[from - 1].pop())
            }
        }

        currentStacks.forEach { println(it) }

        val topValues = currentStacks.map { it.peek() }.joinToString(separator = "")
        println(topValues)

        return input.size
    }

    fun part2(input: List<String>): Int {
        val (moves, stacks) = input.filterNot { it == "" }.partition {
            it.contains("move")
        }

        // stacks
        val numStacks = stacks.last().last().toString().toInt()
        val stackValues = stacks.dropLast(1).reversed()

        val currentStacks = readListByColumn(stackValues, numStacks)

        //moves
        val regex = Regex("(\\d+)")

        val updatedMoves = moves.map { move ->
            regex.findAll(move).map { it.value.toInt() }.toList()
        }

        //operation
        updatedMoves.forEach { (move, from, to) ->
            currentStacks[to - 1].addAll(currentStacks[from - 1].takeLast(move))
            for (i in 0 until move) {
                currentStacks[from - 1].pop()
            }
        }

        currentStacks.forEach { println(it) }

        val topValues = currentStacks.map { it.peek() }.joinToString(separator = "")
        println(topValues)

        return input.size
    }

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))



}

fun readListByColumn(list: List<String>, numStacks: Int): MutableList<Stack<Char?>> {

    val stacks = MutableList(numStacks) { Stack<Char?>() }

    val maxLength = list.map { it.length }.max() ?: 0
    for (i in 0 until maxLength) {
        if ((i - 1) % 4 == 0) {
//            println("i = $i")
            for (str in list) {
                if (i < str.length) {
                    if (str[i] != ' ') {
                        stacks[(i - 1) / 4].push(str[i])
                    }
                }
            }
        }
    }

    return stacks
}