package com.example.consuminglib.test

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidlib.FakePeopleService
import com.example.androidlib.PeopleModule
import com.example.androidlib.PeopleService
import com.example.consuminglib.peoplescreen.PeopleScreen
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
//@UninstallModules(PeopleModule::class)
class PeopleScreenTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<HiltTestActivity>()

    @Inject
    lateinit var peopleService: PeopleService
//    @BindValue
//    val personService: PeopleService = FakePeopleService()


    @Before
    fun setUp(){
        hiltRule.inject()
    }

    @Test
    fun rendersTheRightName() = runTest {
        composeRule.setContent {
            PeopleScreen()
        }

        runCurrent()

        println("PEOPLE SERVICE $peopleService")

        composeRule.onNodeWithTag("people_list")
            .onChildren().filterToOne(
                hasText("Pepe")
            ).assertIsDisplayed()
    }
}