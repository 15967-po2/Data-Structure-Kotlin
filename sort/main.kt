/**
* Nuno Ricardo Martins Cruz
* 15967@alunos.ipbeja.pt
* 15967
*/

import kotlin.system.measureTimeMillis
import org.opencv.core.Core
import org.opencv.core.Mat
import org.opencv.imgcodecs.Imgcodecs
import kotlin.math.floor
import java.io.File

fun main(){
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME)

    val img = "images/img.jpg"
    val image : Mat = Imgcodecs.imread(img, Imgcodecs.IMREAD_GRAYSCALE)
    val arraySize = image.rows() * image.cols()
    val array : IntArray = IntArray(arraySize)

    var pos : Int = 0
    for (i in 1 until image.rows()){
        for (j in 1 until image.cols()) {
            array[pos] = image.get(i, j)[0].toInt()
            pos++
        }
    }
	
	// Returns execution time (ms)
    val runningTime : Long = measureTimeMillis{ bucketSort(array,arraySize) }

//    for (i in 0 until arraySize){
//        print(array[i])
//    }

    println(runningTime)
}

fun bucketSort(array: IntArray, arraySize : Int){

	// Variable that sets otal buckets size
    val bucketSize : Int = 100

    val emptyArray : MutableList<MutableList<Int>> = mutableListOf()

	// Creates the buckets
    for (i in 0..bucketSize){ 
        val bucket: MutableList<Int> = mutableListOf()
        emptyArray.add(bucket)
    }

    for(j in 0 until arraySize) {
        val value : Int = array[j]
        var index : Int = floor((bucketSize*value / array.max()!!).toDouble()).toInt()
        emptyArray[index].add(value)
    }

    for (m in 0..bucketSize){
        emptyArray[m] = insertionSort(emptyArray[m])
    }

    var k = 0

	// Writes data in data file called data.tx
    for(n in 0..bucketSize){
        for(l in 0 until emptyArray[n].count()){
            var value = emptyArray[n][l]
            if ( value != 0) {
                array[k] = value
                File("graphs/gnuplot/data.txt").appendText(value.toString() + "\n")
                k++
            }
        }
    }
}

fun insertionSort(bucketList : MutableList<Int>) : MutableList<Int>{

	// Arranges distribuition for each bucket
    for(i in 1 until bucketList.size){
        var current : Int = bucketList[i]
        var order :Int = i-1

        while(order>=0 && bucketList[order]>current){
            bucketList[order+1] = bucketList[order]
            order--
        }
        bucketList[order+1]=current
    }
    return bucketList
}

