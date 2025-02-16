package com.example.weatherapp

data class TodayInfo(
    var stateWeather: Int,
    var nameCity: String,
    var temperature: Int,
    var kmh: Int,
    var humidity: Int,
    var areaRain: Int
)