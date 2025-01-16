package mo.ed.weather.domain.usecase

import mo.ed.weather.data.model.WeatherResponse
import mo.ed.weather.data.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(city: String, apiKey: String): WeatherResponse {
        return repository.fetchWeather(city, apiKey)
    }
}