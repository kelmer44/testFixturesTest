package com.example.androidlib

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakePersonService : PeopleService {
    override fun getPeople(): Flow<List<Person>> {
        return flowOf(
            listOf(
                Person(1, "Mike", "https://randomavatar.com/avatar/8471123"),
                Person(2, "Mike", "https://randomavatar.com/avatar/8471123"),
            )
        )
    }
}