package com.example.androidlib

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class DefaultPeopleService @Inject constructor(
    private val peopleDataSource: PeopleDataSource
) : PeopleService {
    override fun getPeople(): Flow<List<Person>> {
        return flowOf(peopleDataSource.getRandomPeople(5))
    }
}