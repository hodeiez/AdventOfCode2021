package day5

import java.io.File


/**
 * Created by Hodei Eceiza
 * Date: 12/5/2021
 * Time: 22:54
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
fun main() {
    val asList = mutableListOf<String>()
//EXAMPLE WORKING BUT NOT PUZZLE

    File("src/main/kotlin/day5/day5.txt").useLines { lines -> lines.forEach { asList.add(it) } }
    val filteredList =
        asList.map { it.split(Regex("->")) }
            .map {
                mutableListOf(
                    mutableListOf(
                        Integer.parseInt(it[0].trim().split(",")[0]),
                        Integer.parseInt(it[0].trim().split(",")[1])
                    ),
                    mutableListOf(
                        Integer.parseInt(it[1].trim().split(",")[0]),
                        Integer.parseInt(it[1].trim().split(",")[1])
                    )
                )
            }
            .toMutableList()

    println(filteredList)
    val biggestNumber = filteredList.flatten().flatten().distinct().maxOrNull()
    val lista = mutableListOf<Int>()
    filteredList.forEach {


        if (it[0][1] == it[1][1]) {
            if (it[0][0] < it[1][0]) {
                for (number in it[1][0] downTo it[0][0]) {
                    lista.add((it[0][1] * biggestNumber!!) - biggestNumber + number)
                    println(it + "-"+((it[0][1] * biggestNumber!!) - biggestNumber + number))

                }
            } else {
                for (number in it[0][0] downTo it[1][0]) {
                   println(it +"-"+((it[0][1] * biggestNumber!!)  + number))
                    lista.add((it[0][1] * biggestNumber!!)  + number)

                }
            }
        } else if (it[0][0] == it[1][0]) {
            if (it[0][1] < it[1][1]) {
                for (number in it[1][1] downTo it[0][1]) {

                    println(it+" - "+((number * biggestNumber!!) + it[0][0]))
                    lista.add(((number * biggestNumber!!) + it[0][0]))
                }
            } else {
                for (number in it[0][1] downTo it[1][1]) {
                   println(it+" - "+((number * biggestNumber!!) + it[0][0]+1))
                    lista.add(((number * biggestNumber!!) + it[0][0]+1))
                }
            }

        }

    }

    println(lista.size - lista.distinct().size)

}
