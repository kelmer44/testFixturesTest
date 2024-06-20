package com.example.androidlib

import java.time.Instant
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.min
import kotlin.random.Random

@Singleton
class PeopleDataSource @Inject constructor() {

    val random = Random(Instant.now().nano)


    private val names = listOf(
        "Mike",
        "Tom",
        "Sarah",
        "John",
        "Sally",
        "Mary",
        "Thomas",
        "George",
        "Kathy",
        "Tim",
        "Susan",
        "Christina",
    )

    private val people = List(names.size) { index ->
        Person(
            index,
            names[index],
            "https://i.pravatar.cc/250?img=$index",
            "${names[index]}@company.com"
        )
    }


    fun getRandomPeople(number: Int) = people.shuffled(random).take(min(number, people.size))
}