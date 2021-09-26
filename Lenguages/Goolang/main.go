package main

import (
	"bufio"
	"encoding/csv"
	"os"
	"strconv"
	"time"
)

var readerBig string
var readerSmall string
var arraySmall [100]int64
var arrayBig [10000]int64
var repetition []string
var line string

func main() {
	readerBig = "C:/Users/Financiero/source/repos/Ordering-Experiment/data/BigSize.csv"
	readerSmall = "C:/Users/Financiero/source/repos/Ordering-Experiment/data/SmallSize.csv"
	createArraysBigs(readerBig)
	createArraysSmalls(readerSmall)
	tratementsAll()
}
func createArraysBigs(path string) {

	data, err := os.Open(readerBig)
	if err != nil {
	}
	scanner := bufio.NewScanner(data)

	var s int
	s = 0
	for scanner.Scan() {
		linea := scanner.Text()
		arrayBig[s], _ = strconv.ParseInt(linea, 0, 64)
		s++
	}

}
func createArraysSmalls(path string) {

	data, err := os.Open(readerSmall)
	if err != nil {
	}
	scanner := bufio.NewScanner(data)

	var s int
	s = 0
	for scanner.Scan() {
		linea := scanner.Text()
		arraySmall[s], _ = strconv.ParseInt(linea, 0, 64)
		s++
	}

}
func tratementsAll() {
	file, err := os.Create("C:/Users/Financiero/source/repos/Ordering-Experiment/data/TratamentsGoolang.csv")
	if err != nil {
	}
	writer := csv.NewWriter(file)
	for i := 0; i < 100; i++ {
		start := time.Now()
		bubbleSortBig(arrayBig)
		duration := time.Since(start)
		duringtime := duration.Milliseconds()
		line = line + strconv.FormatInt(int64(duringtime), 10) + "|"

		start = time.Now()
		bubbleSortSmall(arraySmall)
		duration = time.Since(start)
		duringtime = duration.Milliseconds()
		line = line + strconv.FormatInt(int64(duringtime), 10) + "|"

		start = time.Now()
		insertionSortBig(arrayBig)
		duration = time.Since(start)
		duringtime = duration.Milliseconds()
		line = line + strconv.FormatInt(int64(duringtime), 10) + "|"

		start = time.Now()
		insertionSortSmall(arraySmall)
		duration = time.Since(start)
		duringtime = duration.Milliseconds()
		line = line + strconv.FormatInt(int64(duringtime), 10) + "|"
		repetition = append(repetition, line)

		err = writer.Write(repetition)

	}

}

func insertionSortBig(array [10000]int64) {
	len := len(array)
	for i := 1; i < len; i++ {
		for j := 0; j < i; j++ {
			if array[j] > array[i] {
				array[j], array[i] = array[i], array[j]
			}
		}
	}
}

func insertionSortSmall(array [100]int64) {
	len := len(array)
	for i := 1; i < len; i++ {
		for j := 0; j < i; j++ {
			if array[j] > array[i] {
				array[j], array[i] = array[i], array[j]
			}
		}
	}
}
func bubbleSortBig(array [10000]int64) {
	for i := 0; i < len(array)-1; i++ {
		for j := 0; j < len(array)-i-1; j++ {
			if array[j] > array[j+1] {
				array[j], array[j+1] = array[j+1], array[j]
			}
		}
	}
}
func bubbleSortSmall(array [100]int64) {
	for i := 0; i < len(array)-1; i++ {
		for j := 0; j < len(array)-i-1; j++ {
			if array[j] > array[j+1] {
				array[j], array[j+1] = array[j+1], array[j]
			}
		}
	}
}
