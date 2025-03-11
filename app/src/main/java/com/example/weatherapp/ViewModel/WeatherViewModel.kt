package com.example.weatherapp.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.API.RetrofitInstance
import com.example.weatherapp.OneDayInfo
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherData = MutableLiveData<MutableList<OneDayInfo>>()
    val weatherData: LiveData<MutableList<OneDayInfo>> = _weatherData

    fun fetchWeather(context: Context) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getWeather()
                val updatedWeatherData = response.map { oneDay ->
                    // Преобразуем строку в ID ресурса
                    val iconId = getDrawableResourceByName(oneDay.stateWeather.toString(), context)
                    oneDay.copy(stateWeather = iconId) // Обновляем stateWeather
                }.toMutableList()
                _weatherData.value = updatedWeatherData
                Log.d("WeatherViewModel", "Данные успешно получены: $response")
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Ошибка при запросе: ${e.message}")
                e.printStackTrace()
            }
        }
    }

    // Функция для получения ID ресурса по имени
    private fun getDrawableResourceByName(resourceName: String, context: Context): Int {
        return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
    }
}

