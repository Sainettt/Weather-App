package com.example.weatherapp.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.API.RetrofitInstance
import com.example.weatherapp.Model.OneDayInfo
import com.example.weatherapp.Model.OneDayInfoResponse
import com.example.weatherapp.R
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherData = MutableLiveData<MutableList<OneDayInfo>>()
    val weatherData: LiveData<MutableList<OneDayInfo>> = _weatherData

    fun fetchWeather() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getWeather()
                _weatherData.value = changeModelInfo(response)
                Log.d("WeatherViewModel", "Данные успешно получены: $response")
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Ошибка при запросе: ${e.message}")
                e.printStackTrace()
            }
        }
    }
    private fun changeModelInfo(response: MutableList<OneDayInfoResponse>): MutableList<OneDayInfo>{
        val weatherMap = mapOf(
            "ic_cloudy" to R.drawable.ic_cloudy,
            "ic_cloudy_sunny" to R.drawable.ic_cloudy_sunny,
            "ic_hail" to R.drawable.ic_hail,
            "ic_murky" to R.drawable.ic_murky,
            "ic_rain" to R.drawable.ic_rain,
            "ic_rainy" to R.drawable.ic_rainy,
            "ic_rainy_sunny" to R.drawable.ic_rainy_sunny,
            "ic_raw" to R.drawable.ic_raw,
            "ic_snow" to R.drawable.ic_snow,
            "ic_sunny" to R.drawable.ic_sunny,
            "ic_thunder" to R.drawable.ic_thunder
        )
        return response.map { response ->
            OneDayInfo(
                nameCity = response.nameCity,
                nameDay = response.nameDay,
                stateWeather = weatherMap[response.stateWeather] ?: R.drawable.ic_to_darken,
                minTemperature = response.minTemperature,
                maxTemperature = response.maxTemperature,
                temperature = response.temperature,
                kmh = response.kmh,
                humidity = response.humidity,
                areaRain = response.areaRain
            )
        }.toMutableList()
    }
}

