package day2

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 12/2/2021
 * Time: 10:28
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
fun main() {

    val asList = mutableListOf<String>()


    File("src/main/kotlin/day2/day2.txt").useLines { lines -> lines.forEach { asList.add(it) } }
    val commands = asList.map { it.split(' ')[0] to it.split(' ')[1] }

    fun commandsSum(command: String): Int {
        return commands.filter { (k, _) -> k == command }.sumOf { Integer.parseInt(it.second) }
    }
    //PART1
    val result = commandsSum("forward") * (commandsSum("down") - commandsSum("up"))
    println(result)

    //PART2
    //to declare this three was the easiest way to solve, sorry Venkat!
    var depth = 0
    var aim = 0
    var horizontal = 0

    val calculator = commands.forEach { (k, v) ->
        when (k) {

            "down" -> {
                aim += Integer.parseInt(v)
            }
            "up" -> {
                aim -= Integer.parseInt(v)
            }
            "forward" -> {
                horizontal += Integer.parseInt(v);
                depth += aim * Integer.parseInt(v)
            }
        }
    }
    println(depth * horizontal)

}
