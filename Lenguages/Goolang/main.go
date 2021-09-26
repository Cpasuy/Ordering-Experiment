package main

import "fmt"

func main() {
 string treatments = "data\datatreatments.csv";
}
func insertionSort(array []int)[]int {
    len := len(array)
    for i := 1; i < len; i++ {
        for j := 0; j < i; j++ {
            if array[j] > array[i] {
                array[j], array[i] = array[i], array[j]
            }
        }
    }
		return array
 }
 func bubbleSort(array[] int)[]int {
   for i:=0; i< len(array)-1; i++ {
      for j:=0; j < len(array)-i-1; j++ {
         if (array[j] > array[j+1]) {
            array[j], array[j+1] = array[j+1], array[j]
         }
      }
   }
   return array
}
