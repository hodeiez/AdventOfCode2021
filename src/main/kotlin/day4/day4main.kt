package day4

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 12/5/2021
 * Time: 10:41
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
fun main() {

    ///VERY dirty! will rewrite some day haha
    val asList = mutableListOf<String>()
    File("src/main/kotlin/day4/day4.txt").useLines { lines ->
        lines.forEach {
            if (it.isNotEmpty()) {
                asList.add(it)
            }
        }
    }
    val points = asList.removeAt(0).split(',')
    val cards = asList.chunked(5).map { it ->
        it.map { it ->
            it.trim().split(' ').filter { it.isNotEmpty() }.map { mutableListOf(Integer.parseInt(it), false) }
        }
    }

    println()
    fun findWin(): String {
        for (c in cards.indices) {

            for (r in 0 until cards[c].size) {

                if (cards[c][0].flatten()[r * 2 + 1] == true && cards[c][1].flatten()[r * 2 + 1] == true && cards[c][2].flatten()[r * 2 + 1] == true && cards[c][3].flatten()[r * 2 + 1] == true && cards[c][4].flatten()[r * 2 + 1] == true) {

                    return "winner col!$c!$r"
                } else if (cards[c][r].flatten()[1] == true && cards[c][r].flatten()[3] == true && cards[c][r].flatten()[5] == true && cards[c][r].flatten()[7] == true && cards[c][r].flatten()[9] == true)
                    return "winner row!$r$c"

            }
        }
        return "po"
    }

    fun findInCard(): MutableList<Int> {
        var keepPoint = 0;
        var cardIndex = 0
        var rowIndex = 0
        for (point in points) {

            if (findWin() === "po") {
                for (c in cards.indices) {
                    for (r in 0 until cards[c].size) {
                        for (v in 0 until cards[c][r].size) {
                            if (cards[c][r][v][0] == Integer.parseInt(point)) {
                                cards[c][r][v][1] = true
                                keepPoint = points.indexOf(point)
                                cardIndex = c
                                rowIndex = r

                            }
                        }
                    }
                }
            } else {
                return mutableListOf(Integer.parseInt(points[keepPoint]), cardIndex, rowIndex)
            }
        }
        return mutableListOf(-1)
    }

    fun calculate(list: List<Int>): Int {
        val pointsDrew =
            points.toMutableList().takeWhile { s -> s != list[0].toString() }.map { n -> Integer.parseInt(n) }

        val shadowedCards=cards.toMutableList() //PART2
        val resp = findWin()

        return if (resp.contains("col")) {
            val theColWinnerCard = cards[Integer.parseInt(resp.split("!")[1])].toMutableList()
            for (r in 0..4) {
                theColWinnerCard[r][Integer.parseInt(resp.split("!")[2])][0] = 0
            }

            theColWinnerCard.forEach { println(it) }
            theColWinnerCard.asSequence().flatten().map { it[0] }.toSet().minus(pointsDrew.toSet())
                .sumBy { it as Int } * list[0]
        } else{
            val theRowWinnerCard = cards[list[1]].toMutableList()
            theRowWinnerCard.removeAt(list[2])

            theRowWinnerCard.asSequence().flatten().map { it[0] }.toSet().minus(pointsDrew.toSet())
                .sumBy { it as Int } * list[0]
        }
    }
    println(calculate(findInCard()))
}
