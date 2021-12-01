package day1

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 12/1/2021
 * Time: 09:46
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
fun main(args: Array<String>) {
    val depthMeasurements = mutableListOf<Int>()

    File("src/main/kotlin/day1/day1.txt").useLines { lines -> lines.forEach { depthMeasurements.add(Integer.parseInt(it)) } }
    //PART1
    println(depthMeasurements.zipWithNext { a, b -> a < b }.count { b -> b })
    //PART2
    println(depthMeasurements.windowed(3).zipWithNext{a,b->a.sum()<b.sum()}.count { b -> b })
}
