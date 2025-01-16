package mo.ed.weather.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mo.ed.weather.R
import mo.ed.weather.presentation.viewmodel.WeatherViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel,
    onModeChange: (Boolean) -> Unit,
    isDarkMode: Boolean,
) {


    val weatherState by viewModel.weatherState.observeAsState()
    val errorState by viewModel.errorState.observeAsState()

    var isDarkMode by remember { mutableStateOf(true) }

    val backgroundColor = if (isDarkMode) Color(0xFF111111) else Color(0xFFFFFFFF)
    val toggleButtonText = if (isDarkMode) "Light Mode" else "Dark Mode"
    val searchBoxColor = if (isDarkMode) Color(0xFF444444) else Color(0xFFFFFFFF)
    val textColor =
        if (isDarkMode) Color.White.copy(alpha = 0.6f) else Color.Black.copy(alpha = 0.6f)

    var state = ""
    val weatherImageRes = weatherState?.let {
        state =  it.weather.get(0).main
        when (state.lowercase()) {
            "Clear" -> R.drawable.ic_sunny // Replace with your sunny icon resource
            "Clouds" -> R.drawable.ic_cloudy // Replace with your cloudy icon resource
            "Rain" -> R.drawable.ic_rainy // Replace with your rainy icon resource
            else -> R.drawable.ic_unknown // Fallback for unknown weather state
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 8.dp, vertical = 16.dp), // Reduced padding
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically // Vertically centered content
            ) {
                // Toggle Button
                Column(
                    modifier = Modifier
                        .weight(0.15f) // Reduced width (20% instead of 15%)
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 80.dp, height = 34.dp) // Reduced size
                            .background(Color(0xFFD9D9D9), shape = CircleShape)
                            .padding(4.dp)
                            .testTag(if (isDarkMode) "Dark" else "Light"), // Add test tag here
                        contentAlignment = if (isDarkMode) Alignment.CenterEnd else Alignment.CenterStart
                    ) {
                        Box(
                            modifier = Modifier
                                .size(26.dp) // Smaller size for the toggle
                                .background(Color(0xFF111111), shape = CircleShape)
                                .clickable {
                                    onModeChange(!isDarkMode) // Update state via callback
                                }
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp)) // Reduced spacing
                    Text(
                        text = toggleButtonText,
                        color = if (isDarkMode) Color.White else Color.Black,
                        fontSize = 12.sp, // Smaller font size
                        textAlign = TextAlign.Center
                    )
                }

                // Search Box
                Box(
                    modifier = Modifier
                        .weight(0.55f) // Maintained width (55%)
                        .height(50.dp) // Reduced height
                        .background(
                            searchBoxColor,
                            shape = RoundedCornerShape(30.dp)
                        ) // Rounded corners with smaller radius
                        .padding(horizontal = 12.dp), // Reduced padding
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search Icon",
                            tint = textColor,
                            modifier = Modifier.size(28.dp) // Smaller icon size
                        )

                        Text(
                            text = "Search for your preferred city...",
                            color = textColor,
                            modifier = Modifier
                                .padding(start = 16.dp) // Adjusted padding
                                .height(24.dp),
                            style = TextStyle(
                                fontSize = 14.sp, // Smaller font size
                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                textAlign = TextAlign.Start,
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.width(20.dp))
                // Location Box (Newly added inside the same row)
                Column(
                    modifier = Modifier
                        .weight(0.25f) // 25% width
                        .height(50.dp), // Reduced height to match other components
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LocationBox()
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CityTimeCard(isDarkMode = isDarkMode)
                Spacer(modifier = Modifier.width(15.dp))
                // WeatherBox with scrolling support
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight() // Ensures the box adjusts according to content
//                        .verticalScroll(rememberScrollState()) // Enables scrolling for the weather box
                ) {
                    if (weatherImageRes != null) {
                        WeatherBox(isDarkMode = isDarkMode, weatherImageRes, state)
                    }
                }
            }

            // Add additional rows or content as needed
        }
    }
}


@Preview(showBackground = true, widthDp = 800, heightDp = 400)
@Composable
fun LandscapeLayoutPreview() {
//    WeatherScreen(isDarkMode = true, weatherState = "rainy", onModeChange = {})
}

