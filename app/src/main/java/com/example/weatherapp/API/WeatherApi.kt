package com.example.weatherapp.API

import com.example.weatherapp.OneDayInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherApi {
    @GET("weather") // путь на сервере
    suspend fun getWeather(): MutableList<OneDayInfo>
}

object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:3000/"

    val api: WeatherApi by lazy {
        Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(WeatherApi::class.java)
    }
}