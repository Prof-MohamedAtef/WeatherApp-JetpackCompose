package mo.ed.weather

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // Use MainActivity for testing

    @Test
    fun toggleButton_switchesBetweenDarkAndLightModes() {
        // Act: Find the toggle button and perform a click
        val toggleButton = composeTestRule.onNodeWithTag( "Dark" )
        toggleButton.assertExists()

        // Verify initial state (dark mode)
        toggleButton.assert(hasTestTag("Dark"))

        // Click the toggle button to switch to light mode
        toggleButton.performClick()
    }

}