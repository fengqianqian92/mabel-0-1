package com.mabel.file.csv

import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import com.opencsv.CSVWriterBuilder
import org.apache.logging.log4j.util.Strings
import java.nio.file.Files
import java.nio.file.Path

class NetworkTxIdFilter {
    fun run() {
        val target = getTargets()
        val newBufferedReader = Files.newBufferedReader(Path.of("./network-tx-id-csv", "iss-dispute-origin.csv"))
        val parser = CSVParserBuilder().withQuoteChar('"').withSeparator(',').build()
        val csvReader = CSVReaderBuilder(newBufferedReader).withCSVParser(parser).withSkipLines(1).build()
        val notFound = mutableListOf<Array<String>>()
        val queryInConditions = mutableListOf<String>()
        csvReader.onEach { it ->
            val networkTxId = it[23]
            if (target.any { it.contains(networkTxId) })
                println("found: $networkTxId")
            else
                it.also { println("not found: ${it[23]}") }.also { notFound.add(arrayOf(it[0],it[23], it[33])) }
                    .also { queryInConditions.add(it[0]) }
        }
        val newBufferedWriter = Files.newBufferedWriter(Path.of("./network-tx-id-csv", "not-found-iss-dispute.csv"))
        val writer = CSVWriterBuilder(newBufferedWriter).build()
        writer.writeNext(arrayOf("id","network_transaction_id", "region"), false) // header
        writer.writeAll(notFound, false)
        writer.flushQuietly()
        println(Strings.join(queryInConditions.map { "'$it'" }, ','))
    }

    fun getTargets(): Set<String> {
        val newBufferedReader = Files.newBufferedReader(Path.of("./network-tx-id-csv", "target-tx-id.csv"))
        val parser = CSVParserBuilder().withQuoteChar('"').withSeparator(',').build()
        val csvReader = CSVReaderBuilder(newBufferedReader).withCSVParser(parser).withSkipLines(5).build()
        return csvReader.map { it[0] }.toSet()
    }
}

fun main() {
    NetworkTxIdFilter().run()
}