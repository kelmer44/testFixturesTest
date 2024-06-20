package com.example.androidlib

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface PersonService {

    fun getPerson(): Flow<List<Person>>
}