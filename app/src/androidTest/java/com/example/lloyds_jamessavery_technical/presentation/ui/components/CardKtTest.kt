package com.example.lloyds_jamessavery_technical.presentation.ui.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.lloyds_jamessavery_technical.mock.MockData
import com.example.lloyds_jamessavery_technical.presentation.ui.MainActivity.Companion.FAVOURITE_BUTTON_TEST_TAG
import com.example.lloyds_jamessavery_technical.presentation.ui.components.Card.Companion.IMAGE_CONTENT_DESCRIPTION
import org.junit.Rule
import org.junit.Test

class CardKtTest {

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    @Test
    fun testCard_showsCorrectDetails() {
        val buttonColour = Color.Red

        composeTestRule.setContent {
            ProcedureDetailCard(
                procedure = MockData.procedureMock,
                favouritesList = listOf(MockData.procedureMock),
                onCardClickEvent = {},
                onFavouriteToggleEvent = {},
                isFavourite = { true }
            )
        }

        composeTestRule.onNodeWithText(MockData.procedureMock.name).assertIsDisplayed()
        composeTestRule.onNodeWithText("Phase Count: ${MockData.procedureMock.phases.size}").assertIsDisplayed()
        composeTestRule.onNodeWithTag("${MockData.procedureMock.uuid}$FAVOURITE_BUTTON_TEST_TAG$buttonColour").assertIsDisplayed()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithContentDescription(IMAGE_CONTENT_DESCRIPTION).assertExists()
    }

}