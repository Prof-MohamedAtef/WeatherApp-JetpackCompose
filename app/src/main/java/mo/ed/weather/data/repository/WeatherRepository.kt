package mo.ed.weather.data.repository

import mo.ed.weather.data.model.WeatherResponse
import mo.ed.weather.data.remote.WeatherApiService
import mo.ed.weather.domain.repository.WeatherRepositoryInterface
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: WeatherApiService
) : WeatherRepositoryInterface {
    override suspend fun fetchWeather(city: String, apiKey: String): WeatherResponse {
        return apiService.getWeather(city, apiKey)
    }

}