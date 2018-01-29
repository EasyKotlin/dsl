package com.easy.kotlin.dsl

fun main(args: Array<String>) {

    val students = listOf(
        Student("jack", "M", 90),
        Student("alice", "F", 70),
        Student("bob", "M", 60),
        Student("bill", "M", 80),
        Student("helen", "F", 100)
    )

    val queryResult = students.select()
        .where { it.score >= 80 }
        .and { it.sex == "M" }

    println(queryResult)
}

fun <E> List<E>.where(predicate: (E) -> Boolean): List<E> {
    val list = this
    val result = arrayListOf<E>()
    for (e in list) {
        if (predicate(e)) {
            result.add(e)
        }
    }
    return result
}

fun <E> List<E>.and(predicate: (E) -> Boolean): List<E> {
    return where(predicate)
}
fun <E> List<E>.select(): List<E> = this
data class Student(var name: String, var sex: String, var score: Int)
