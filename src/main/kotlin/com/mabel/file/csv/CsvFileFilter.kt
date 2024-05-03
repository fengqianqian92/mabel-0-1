package com.mabel.file.csv

import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.writeLines

class CsvFileFilter {
    fun filterByRowNo() {
//        val createFile = Files.createFile(Path.of("test.txt"))
//        println(createFile.toAbsolutePath())
        val csvFileLines = Files.readAllLines(Path.of("./csv/dispute_migration_20231007.csv"))
//        println(csvFileLines)
        val lineNumbers = Files.readAllLines(Path.of("./csv/row_number.txt")).map { it.toInt() }
//        println(lineNumbers)

        val outputFile = Files.createFile(Path.of("./csv/output.csv"))


        val targetRows = mutableListOf<String>()

        // insert header row
        targetRows.add(csvFileLines[0])
        csvFileLines.forEachIndexed { index, row -> if (lineNumbers.contains(index+1))  targetRows.add(row)}

        outputFile.writeLines(targetRows)
    }
}

fun main() {
    CsvFileFilter().filterByRowNo()
}