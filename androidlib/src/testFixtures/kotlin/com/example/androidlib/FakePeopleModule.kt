package com.example.androidlib

import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [PeopleModule::class]
)
interface FakePeopleModule {
    @Binds
    fun bindsPeopleService(
        defaultPeopleService: FakePeopleService
    ): PeopleService
}