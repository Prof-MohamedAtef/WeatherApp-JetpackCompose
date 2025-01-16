package mo.ed.weather.presentation.features.weather.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mo.ed.weather.R

@Composable
fun LocationBox() {
    Box(
        modifier = Modifier
            .height(62.dp)
            .background(
                Color(0xFF4CBB17),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(40.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)  // Padding for the icon to the left
                .wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            // Use Coil to load SVG image
            val painter = painterResource(id = R.drawable.ic_location)  // Use your SVG resource path

            Image(
                painter = painter,
                contentDescription = "Location Icon",
                modifier = Modifier
                    .height(50.dp)  // Height to cover 80% of the box height
                    .width(50.dp),  // Set width to desired value or ratio
                contentScale = ContentScale.Fit // Scale the image to fill the height properly
            )

            // Text
            Text(
                text = "Current Location",
                color = Color.White,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif, // Replace with Poppins if available
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(start = 4.dp) // Padding between the icon and text
            )
        }
    }
}

@Preview
@Composable
fun LocationBoxPreview() {
    LocationBox()
}