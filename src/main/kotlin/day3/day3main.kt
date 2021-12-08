package day3

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 12/3/2021
 * Time: 08:25
 * Project: AdventOfCode2021
 * Copyright: MIT
 */

fun main() {
    val asList = mutableListOf<String>()


    File("src/main/kotlin/day3/day3.txt").useLines { lines -> lines.forEach { asList.add(it) } }
//PART 1 (DIRTY FIX)to refactor
    fun getValues(binaryToCount:Int): Int {
        val result=StringBuilder();
        var stringL=asList[0].length
        var i=0
        while(stringL>0){
        if(asList.map{s->s[i]}.filter{s->Integer.parseInt(s.toString())==binaryToCount}.count()>asList.size/2){result.append(1)}else{result.append(0)}
       i++
        stringL--
        }

        return Integer.parseInt(result.toString(),2)
    }

    println(getValues(0)*getValues(1))

    //PART 2 (DIRTY FIX)

    fun oxygenRating(listToFilter:List<String>,i:Int): List<String> {

        if(listToFilter.size!=1 ){
            val newList=listToFilter.filter{s->Integer.parseInt(s[i].toString())==1}
            val newList2=listToFilter.filter{s->Integer.parseInt(s[i].toString())==0}

            val next=i+1

            return if(newList.size>=newList2.size){
                oxygenRating(newList,next)
            } else
                oxygenRating(newList2,next)
       }

        return listToFilter
    }
    fun c02ScrubRating(listToFilter:List<String>, i:Int): List<String> {

        if(listToFilter.size!=1 ){
            val newList=listToFilter.filter{s->Integer.parseInt(s[i].toString())==0}
            val newList2=listToFilter.filter{s->Integer.parseInt(s[i].toString())==1}

            val next=i+1

            return if(newList.size<=newList2.size){
                c02ScrubRating(newList,next)
            } else
                c02ScrubRating(newList2,next)
        }

        return listToFilter
    }
   print( Integer.parseInt(c02ScrubRating(asList,0)[0],2)*Integer.parseInt(oxygenRating(asList,0)[0],2))


}

