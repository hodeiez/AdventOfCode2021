package day8

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 12/8/2021
 * Time: 21:47
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
fun main() {
    val asList = mutableListOf<String>()
    File("src/main/kotlin/day8/day8.txt").useLines { lines -> lines.forEach { asList.add(it) } }
val admitted=listOf("abcefg","cf","acdeg","acdfg","bcdf","abdfg","abdefg","acf","abcdefg","abcdfg")
val validNumberSegments=listOf(2,4,3,7)
    var counter=0

    //PART 1
    asList.forEach { println(it) }
    val theList=asList.map{it.split(" |").map{
        it.split(" ").map{
            it.toCharArray().sorted().joinToString("")
        }
    }}.flatten()


    for(i in 0 until theList.size-1 step 2){
        for(a in 0 until theList[i+1].size)
            for(b in 0 until theList[i].size)
                if(theList[i][b].length ==theList[i+1][a].length &&theList[i][b]==theList[i+1][a]) {
                    val amountOfSegments=theList[i][b].length
                    if(amountOfSegments==validNumberSegments[0] ||
                        amountOfSegments==validNumberSegments[1]||
                        amountOfSegments==validNumberSegments[2]||
                        amountOfSegments==validNumberSegments[3]){

                    counter++}
                }
    }
    println(counter)
}
