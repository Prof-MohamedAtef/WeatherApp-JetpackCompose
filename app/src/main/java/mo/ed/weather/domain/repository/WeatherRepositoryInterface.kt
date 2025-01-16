package mo.ed.weather.domain.repository

import mo.ed.weather.data.model.WeatherResponse

interface WeatherRepositoryInterface {
    suspend fun fetchWeather(city: String, apiKey: String): WeatherResponse
}