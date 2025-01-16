package mo.ed.weather.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mo.ed.weather.data.model.WeatherResponse
import mo.ed.weather.domain.usecase.GetWeatherUseCase
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weatherState = MutableLiveData<WeatherResponse>()
    val weatherState: LiveData<WeatherResponse> get() = _weatherState

    private val _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> get() = _errorState

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = getWeatherUseCase(city, apiKey)
                _weatherState.value = response
            } catch (e: Exception) {
                _errorState.value = e.localizedMessage ?: "An error occurred"
            }
        }
    }
}