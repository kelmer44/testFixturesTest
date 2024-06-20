package com.example.androidlib

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PeopleModule {

    @Binds
    fun bindsPeopleService(
        defaultPeopleService: DefaultPeopleService
    ): PeopleService
}