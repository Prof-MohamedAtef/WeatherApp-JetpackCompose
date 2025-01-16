package mo.ed.weather.presentation.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import mo.ed.weather.presentation.ui.screen.WeatherScreen
import mo.ed.weather.presentation.viewmodel.WeatherViewModel
import mo.ed.weather.ui.theme.MyWeatherAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(
                        viewModel = viewModel,
                        onModeChange = {},
                        isDarkMode = true,
                    )
                }
            }
        }

        viewModel.fetchWeather("Cairo", "ea2f2f3b31cbc318071a99d9a7b5de08")
    }
}