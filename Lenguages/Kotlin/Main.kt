import java.io.*



fun main(args: Array<String>) {
    var myArray = mutableListOf(7,1,9,3,22,6)
    val result = bubbleSort(myArray)
    println(result)
}

fun timeSorting() {

    val timeForBeginBigSizeBubbleSort : MutableList<Long> = ArrayList()
    val timeForSmallSizeBubbleSort : MutableList<Long> = ArrayList()
    val timeForBeginBigSizeInsertionSort : MutableList<Long> = ArrayList()
    val timeForBeginSmallSizeInsertionSort : MutableList<Long> = ArrayList()

    val t1 = readFileBigSize()
    val t2 = readFileSmallSize()
    val t3 = readFileBigSize()
    val t4= readFileBigSize()

    val f = File("C:/Users/ander/Downloads/kotlin-validation-service/Kotlin/data/TratementsJava.csv")
    var txt = ""

    for (i in 0 ..100){
        //Buble sort big size
        val beginBigSizeBubbleSort = System.nanoTime()
        bubbleSort( t1 as MutableList<Int>)
        val endBigSizeBubbleSort = System.nanoTime()
        val tempBigSizeBubbleSort = endBigSizeBubbleSort - beginBigSizeBubbleSort
        timeForBeginBigSizeBubbleSort.add(tempBigSizeBubbleSort)

        txt += "$tempBigSizeBubbleSort |"




        // Buble sort small time

        val beginSmallSizeBubbleSort = System.nanoTime()
        bubbleSort( t2 as MutableList<Int>)
        val endSmallSizeBubbleSort = System.nanoTime()
        val tempSmallSizeBubbleSort = endSmallSizeBubbleSort - beginSmallSizeBubbleSort
        timeForSmallSizeBubbleSort.add(tempSmallSizeBubbleSort)

        txt += "$tempSmallSizeBubbleSort |"

        // Insertion sort Big Size

        val beginBigSizeInsertionSort = System.nanoTime()
        insertionSort( t3 as MutableList<Int>)
        val endBigSizeInsertionSort = System.nanoTime()
        val tempBigSizeInsertionSort = endBigSizeInsertionSort - beginBigSizeInsertionSort
        timeForBeginBigSizeInsertionSort.add(tempBigSizeInsertionSort)

        txt += "$tempBigSizeInsertionSort |"

        // Insertion sort small size

        val beginSmallSizeInsertionSort = System.nanoTime()
        insertionSort(t4 as MutableList<Int>)
        val endSmallSizeInsertionSort = System.nanoTime()
        val tempSmallSizeInsertionSort = endSmallSizeInsertionSort - beginSmallSizeInsertionSort
        timeForBeginSmallSizeInsertionSort.add(tempSmallSizeInsertionSort)

        txt += "$tempSmallSizeInsertionSort |"




    }

    File("C:/Users/ander/Downloads/kotlin-validation-service/Kotlin/data/TratementsJava.csv").writeText(txt)


}

fun readFileBigSize(): List<Int>{

    val pathNameSmallSize = "C:/Users/ander/Downloads/kotlin-validation-service/Kotlin/data/BigSize.csv"
    val miArchivo = File(pathNameSmallSize)
    val inputStream: InputStream = miArchivo.inputStream()
    val contenido = inputStream.readBytes().toString(Charset.defaultCharset())
    contenido.trim()
    val nums = contenido.split("\n")
    val listBigSize : MutableList<Int> = ArrayList()

    for(i in 0..nums.size-2){

        listBigSize.add(nums[i].trim().toInt())

    }


    return listBigSize

}

fun readFileSmallSize(): List<Int>{

    val pathNameSmallSize = "C:/Users/ander/Downloads/kotlin-validation-service/Kotlin/data/SmallSize.csv"
    val miArchivo = File(pathNameSmallSize)
    val inputStream: InputStream = miArchivo.inputStream()
    val contenido = inputStream.readBytes().toString(Charset.defaultCharset())
    contenido.trim()
    val nums = contenido.split("\n")
    val listBigSize : MutableList<Int> = ArrayList()

    for(i in 0..nums.size-2){

        listBigSize.add(nums[i].trim().toInt())

    }


    return listBigSize

}


fun bubbleSort(array: MutableList<Int>):  {
    if (array.size == 0) return array
    var isSorted = false
    var counter = 0
    while (!isSorted) {
        isSorted = true
        for (i in 0 until array.size - 1 - counter) {
            if(array[i] > array[i+1]) {
                isSorted = false
                swap(array, i, i + 1)
            }
        }
        counter++
    }
}

fun swap(array: MutableList<Int>, i: Int, j: Int) {
    val temp = array[j]
    array[j] = array[i]
    array[i] = temp
}


fun insertionSort(items:MutableList<Int>){
    if (items.isEmpty() || items.size<2){
        return items
    }
    for (count in 1..items.count() - 1){
        // println(items)
        val item = items[count]
        var i = count
        while (i>0 && item < items[i - 1]){
            items[i] = items[i - 1]
            i -= 1
        }
        items[i] = item
    }

}