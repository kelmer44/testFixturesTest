package com.example.consuminglib.test

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.filter
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import com.example.consuminglib.peoplescreen.PeopleScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
class PeopleScreenTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<HiltTestActivity>()

    @Test
    fun rendersTheRightName() = runTest {
        composeRule.setContent {
            PeopleScreen()
        }

        runCurrent()

        composeRule.onNodeWithTag("people_list")
            .onChildren().filterToOne(
                hasText("Pepe")
            ).assertIsDisplayed()
    }
}