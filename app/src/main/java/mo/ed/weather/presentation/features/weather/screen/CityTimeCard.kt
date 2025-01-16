package mo.ed.weather.presentation.features.weather.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CityTimeCard(isDarkMode: Boolean) {
    val cardBackgroundColor = if (isDarkMode) Color(0xFF444444) else Color.White
    val textColor = if (isDarkMode) Color.White else Color.Black

    Box(
        modifier = Modifier
            .width(270.dp)
            .height(280.dp)
            .clip(RoundedCornerShape(15.dp)) // Rounded corners with 15 dp
            .background(cardBackgroundColor) // Dynamic background color
            .padding(16.dp), // Padding inside the box
        contentAlignment = Alignment.Center // Center content
    ) {
        // Use verticalScroll on the Column to make it scrollable
        Column(
            modifier = Modifier
                .wrapContentSize()
                .verticalScroll(rememberScrollState()) // Enables vertical scrolling
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.wrapContentSize()
            ) {
                // City Title
                Text(
                    text = "Athens", // Example city title
                    color = textColor, // Dynamic text color
                    fontSize = 32.sp, // Reduced font size for a more compact look
                    fontWeight = FontWeight.ExtraBold,
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp)) // Reduced spacing

                // Time
                Text(
                    text = "09:30", // Example time
                    color = textColor, // Dynamic text color
                    fontSize = 70.sp, // Reduced font size for the time
                    fontWeight = FontWeight.ExtraBold,
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                // Date
                Text(
                    text = "Thursday, 16 Jan", // Example date
                    color = textColor, // Dynamic text color
                    fontSize = 20.sp, // Reduced font size for the date
                    fontWeight = FontWeight.Normal,
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 800, heightDp = 400)
@Composable
fun CityTimeCardPreview() {
    CityTimeCard(isDarkMode = false)
}