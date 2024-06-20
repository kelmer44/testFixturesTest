## Hilt with Test Fixtures

The project demonstrates Hilt not processing annotated resources in newly released (still experimental) Android module's `testFixtures`.

This is a very simple Compose app that displays a list of random people. I've created an instrumentation test for this screen in the `consuminglib` module.

The `androidlib` module declares a `PeopleService`interface and a default implementation, which is bound in `PeopleModule`.

Within the `androidlib` module I've put a `FakePeopleService` (which offers deterministic results, ideal for tests), and also my `FakePeopleModule` where I use `@TestInstallIn` to replace the module declared in the main source set.

```kotlin
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
```

When running my test from `consuminglib` the binding is never replaced, and no generated code is produced for `testFixtures`.

You'll find that in `PeopleScreenTest` some lines are commented out, those do work in replacing the binding with the fake implementation, which goes to prove that `testFixtures` does actually get properly imported.
