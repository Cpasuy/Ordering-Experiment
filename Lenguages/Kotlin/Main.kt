import java.io.*



fun main(args: Array<String>) {
    var myArray = mutableListOf(7,1,9,3,22,6)
    val result = bubbleSort(myArray)
    println(result)
}



fun readFileLineByLineUsingForEachLine(fileName: String):List<Int>
{
    val f = File(a)
    val array = arrayOf<Int>(100)
    File(a).read
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