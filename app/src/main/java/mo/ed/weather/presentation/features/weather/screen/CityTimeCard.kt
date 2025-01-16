package mo.ed.weather.presentation.features.weather.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
            .width(290.dp)
            .height(300.dp)
            .clip(RoundedCornerShape(15.dp)) // Rounded corners with 15 dp
            .background(cardBackgroundColor) // Dynamic background color
            .padding(16.dp), // Padding inside the box
        contentAlignment = Alignment.Center // Center content
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // City Title
            Text(
                text = "Athens", // Example city title
                color = textColor, // Dynamic text color
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                style = TextStyle(
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp)) // Spacing between title and time

            // Time
            Text(
                text = "09:30", // Example time
                color = textColor, // Dynamic text color
                fontSize = 90.sp,
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
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                style = TextStyle(
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 800, heightDp = 400)
@Composable
fun CityTimeCardPreview() {
    CityTimeCard(isDarkMode = false)
}