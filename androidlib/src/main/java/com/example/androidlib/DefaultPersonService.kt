package com.example.androidlib

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultPersonService @Inject constructor(): PersonService{


    override fun getPerson(): Flow<List<Person>> {
        return
    }
}