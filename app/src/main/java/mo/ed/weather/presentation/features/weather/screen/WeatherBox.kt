package mo.ed.weather.presentation.features.weather.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mo.ed.weather.R

@Composable
fun WeatherBox(isDarkMode: Boolean, weatherImageRes: Int, weatherState: String) {
    val cardBackgroundColor = if (isDarkMode) Color(0xFF444444) else Color.White
    val textColor = if (isDarkMode) Color.White else Color.Black

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .clip(RoundedCornerShape(15.dp)) // Rounded corners with 15 dp
            .background(cardBackgroundColor) // Dynamic background color
            .padding(horizontal = 16.dp), // Padding inside the box
        contentAlignment = Alignment.Center // Center content
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // First Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(), // Ensures the column uses the available width
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "75°F",
                    color = textColor,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Feels like:",
                        color = textColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        maxLines = 1,
                        overflow = TextOverflow.Clip
                    )
                    Text(
                        text = "22°C",
                        color = textColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Clip
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sunrise),
                        contentDescription = "Sunrise Icon",
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Sunrise",
                            color = textColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "06:37 AM",
                            color = textColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sunset),
                        contentDescription = "Sunset Icon",
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Sunset",
                            color = textColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "20:37 PM",
                            color = textColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(15.dp))

            // Second Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = weatherImageRes),
                    contentDescription = "Weather State Image",
                    modifier = Modifier
                        .size(200.dp) // Reduced padding to bring text closer
                )

                Text(
                    text = weatherState,
                    color = textColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Third Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_humidity),
                    contentDescription = "Humidity Icon",
                    tint = if (isDarkMode) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "41%",
                    color = textColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Humidity",
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(24.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_pressure),
                    contentDescription = "Pressure Icon",
                    tint = if (isDarkMode) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "9975Pa",
                    color = textColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Pressure",
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Fourth Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_wind_speed),
                    contentDescription = "Wind Speed Icon",
                    tint = if (isDarkMode) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "2km/h",
                    color = textColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Wind Speed",
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(24.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_uv),
                    contentDescription = "UV Icon",
                    tint = if (isDarkMode) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "8",
                    color = textColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "UV",
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview
@Composable
fun WeatherBoxPreview(weatherState: String = "cloudy"){
    val weatherImageRes = when (weatherState.lowercase()) {
        "sunny" -> R.drawable.ic_sunny // Replace with your sunny icon resource
        "cloudy" -> R.drawable.ic_cloudy // Replace with your cloudy icon resource
        "rainy" -> R.drawable.ic_rainy // Replace with your rainy icon resource
        else -> R.drawable.ic_unknown // Fallback for unknown weather state
    }

    WeatherBox(isDarkMode = false,weatherImageRes, weatherState = "cloudy")
}