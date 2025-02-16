package com.example.weatherapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.TodayInfo
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.FragmentOneDayInfoBinding
import java.time.DayOfWeek
import kotlin.random.Random

class OneDayFragment: Fragment() {
    private lateinit var binding: FragmentOneDayInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneDayInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val day = generateInfoOneDay()
        applySettings(day)
    }
    fun generateInfoOneDay(): TodayInfo{
        val stateWeather = R.drawable.ic_sunny
        val nameCity = "Moscow"
        val temperature = Random.nextInt(30, 45)
        val kmh = Random.nextInt(10,20)
        val humidity = Random.nextInt(30,100)
        val areaRain = Random.nextInt(50,80)

        return TodayInfo(stateWeather, nameCity, temperature, kmh, humidity, areaRain)
    }
    fun applySettings(day: TodayInfo){
        binding.stateWeather.setImageResource(day.stateWeather)
        binding.city.text = day.nameCity
        binding.temperature.text = day.temperature.toString()
        binding.kmh.text = day.kmh.toString()
        binding.humidity.text = day.humidity.toString()
        binding.areaRain.text = day.areaRain.toString()
    }
}