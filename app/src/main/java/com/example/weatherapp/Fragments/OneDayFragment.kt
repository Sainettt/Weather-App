package com.example.weatherapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.OneDayInfo
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentOneDayInfoBinding
import kotlin.random.Random

class OneDayFragment: Fragment() {

    private lateinit var binding: FragmentOneDayInfoBinding
    private var dayInfo: OneDayInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dayInfo = it.getParcelable("dayInfo")
        }
    }
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

          dayInfo?.let { applySettings(it) }
//        val day = generateInfoOneDay()
//        applySettings(day)

    }

    private fun generateInfoOneDay(): OneDayInfo{
        val nameCity = "Moscow"
        val stateWeather = R.drawable.ic_sunny
        val temperature = Random.nextInt(30, 45)
        val kmh = Random.nextInt(10,20)
        val humidity = Random.nextInt(30,100)
        val areaRain = Random.nextInt(50,80)

        return OneDayInfo(nameCity,"",stateWeather,0,0,temperature,kmh,humidity,areaRain)
    }

    private fun applySettings(day: OneDayInfo){
        binding.stateWeather.setImageResource(day.stateWeather)
        binding.city.text = day.nameCity
        binding.temperature.text = day.temperature.toString()
        binding.kmh.text = day.kmh.toString() + " km/h"
        binding.humidity.text = day.humidity.toString() + "%"
        binding.areaRain.text = day.areaRain.toString() + "%"
    }
}