package com.example.androidlib

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakePeopleService @Inject constructor() : PeopleService {
    override fun getPeople(): Flow<List<Person>> {
        return flowOf(
            listOf(
                Person(1, "Pepe", "https://randomavatar.com/avatar/8471123", "mike@email.com"),
                Person(2, "Mariano", "https://randomavatar.com/avatar/8471123", "tom@email.com"),
            )
        )
    }
}