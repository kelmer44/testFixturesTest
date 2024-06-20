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
interface FakePersonModule {
    @Binds
    fun bindsPeopleService(
        defaultPeopleService: FakePersonService
    ): PeopleService
}