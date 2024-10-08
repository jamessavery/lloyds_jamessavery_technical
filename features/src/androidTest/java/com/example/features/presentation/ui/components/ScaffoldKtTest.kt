package com.example.features.presentation.ui.components

import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.core.presentation.ui.components.ProceduresScaffold
import com.example.core.mock.MockData
import com.example.features.favourites.presentation.ui.screens.FAVOURITES_TEST_TAG
import com.example.features.favourites.presentation.ui.screens.FavouritesScreen
import com.example.features.procedures.presentation.ui.screens.PROCEDURE_LIST_TEST_TAG
import com.example.features.procedures.presentation.ui.screens.ProceduresScreen
import com.example.features.shared.viewmodels.MainViewModel
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ScaffoldKtTest {

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    private val errorScreenMessage = "Something went wrong, please try again later"

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testScaffold_showsCorrectTab_canSuccessfullySwapBetween() {
        val procedureList = listOf(
            MockData.procedureMock,
            MockData.procedureMock.copy(uuid = "1"),
            MockData.procedureMock.copy(uuid = "12")
        )
        val favouriteList = listOf(MockData.procedureMock)

        composeTestRule.setContent {
            ProceduresScaffold(
                SnackbarHostState(),
                {
                    ProceduresScreen(
                        uiState = MainViewModel.ProceduresState(
                            items = procedureList
                        ),
                        fetchProcedureDetailEvent = {},
                        onFavouriteToggleEvent = {},
                        fetchProceduresAndFavourites = {},
                        isFavourite = { true }
                    )
                },
                {
                    FavouritesScreen(
                        uiState = MainViewModel.ProceduresState(
                            items = favouriteList,
                            favouriteItems = favouriteList
                        ),
                        onFavouriteToggleEvent = {},
                        fetchFavourites = {},
                        onFetchProcedureDetailEvent = {},
                        isFavourite = { true }
                    )
                }
            )
        }

        // Shows correct tab on startup
        composeTestRule.onNodeWithTag(PROCEDURE_LIST_TEST_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(FAVOURITES_TEST_TAG).assertIsNotDisplayed()

        composeTestRule.onNodeWithTag(errorScreenMessage).assertIsNotDisplayed()

        // Swap to other tab
        composeTestRule.onNodeWithText("Favourites").performClick()
        composeTestRule.waitUntilNodeCount(
            matcher = hasTestTag(FAVOURITES_TEST_TAG),
            count = 1,
            5000L
        )
        composeTestRule.waitForIdle()

        // Shows correct tab after swapping
        composeTestRule.onNodeWithTag(FAVOURITES_TEST_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(PROCEDURE_LIST_TEST_TAG).assertIsNotDisplayed()

        composeTestRule.onNodeWithTag(errorScreenMessage).assertIsNotDisplayed()
    }
}