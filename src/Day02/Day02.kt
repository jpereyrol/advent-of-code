package Day02

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val rounds = input.map { line -> line.filterNot { it.isWhitespace() } }
        val scoreResults = rounds.map { it.processRound() }
        return scoreResults.sum()
    }

    fun part2(input: List<String>): Int {
        val rounds = input.map { line -> line.filterNot { it.isWhitespace() } }
        val scoreResults = rounds.map { it.processRoundDecrypted() }
        return scoreResults.sum()
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))

}

fun String.processRound(): Int {
    return this.last().getRockPaperScissorValue() + if (this == "AX" || this == "BY" || this == "CZ") {
        Values.DRAW_SCORE
    } else if (this == "CX" || this == "AY" || this == "BZ") {
        Values.WIN_SCORE
    } else {
        Values.LOSS_SCORE
    }
}

fun String.processRoundDecrypted(): Int {
    if (this.last() == 'X') {
        // loss
        return Values.LOSS_SCORE + this.first().getValueForLoss()

    } else if (this.last() == 'Y') {
        //DRAW
        return Values.DRAW_SCORE + this.first().getValueForDraw()

    } else {
        //WIN
        return Values.WIN_SCORE + this.first().getValueForWin()
    }
}

fun Char.getValueForLoss(): Int {
    return when(this) {
        'A' -> 3
        'B' -> 1
        else -> 2
    }
}

fun Char.getValueForWin(): Int {
    return when(this) {
        'A' -> 2
        'B' -> 3
        else -> 1
    }
}

fun Char.getValueForDraw(): Int {
    return when(this) {
        'A' -> 1
        'B' -> 2
        else -> 3
    }
}

fun Char.getRockPaperScissorValue(): Int {
    return when(this) {
        'X' -> Values.ROCK_SCORE
        'Y' -> Values.PAPER_SCORE
        'Z' -> Values.SCISSOR_SCORE
        else -> 0
    }
}

object Values {
    const val ROCK_SCORE = 1
    const val PAPER_SCORE = 2
    const val SCISSOR_SCORE = 3
    const val DRAW_SCORE = 3
    const val WIN_SCORE = 6
    const val LOSS_SCORE = 0
}