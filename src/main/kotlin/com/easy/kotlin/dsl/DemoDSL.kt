package com.easy.kotlin.dsl

import java.io.*

fun main(args: Array<String>) {
    val lines =
        "src/main/resources/data.txt"
            .stream()
            .buffered()
            .reader("utf-8")
            .readLines()

    lines.forEach(::println)
}

fun String.stream() = FileInputStream(this)
fun FileInputStream.buffered() = BufferedInputStream(this)
fun InputStream.reader(charset: String) = InputStreamReader(this, charset)
fun Reader.readLines(): List<String> {
    val result = arrayListOf<String>()
    forEachLine {
        result.add(it)
    }
    return result
}
