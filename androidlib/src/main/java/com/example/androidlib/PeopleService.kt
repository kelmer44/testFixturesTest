package com.example.androidlib

import kotlinx.coroutines.flow.Flow

interface PeopleService {

    fun getPeople(): Flow<List<Person>>
}