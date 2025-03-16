package com.example.weatherapp.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OneDayInfoResponse(
    var nameCity: String,
    var nameDay: String,
    var stateWeather: String,
    var minTemperature: Int,
    val maxTemperature: Int,
    var temperature: Int,
    var kmh: Int,
    var humidity: Int,
    var areaRain: Int
) : Parcelable