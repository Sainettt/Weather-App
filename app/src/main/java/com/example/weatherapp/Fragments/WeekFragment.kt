package com.example.weatherapp.Fragments

import android.media.midi.MidiManager.OnDeviceOpenedListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.Adapters.WeekDaysAdapter
import com.example.weatherapp.OneDayInfo
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeekInfoBinding
import kotlin.math.max
import kotlin.random.Random

class WeekFragment: Fragment() {
    private lateinit var binding: FragmentWeekInfoBinding
    private val listOfDays = listOf(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeekInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val week = generateListOfDays()
        val adapter = WeekDaysAdapter(week)
        binding.recyclerViewWeekInfo.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewWeekInfo.adapter = adapter
    }

    fun randomInfoOfDay():OneDayInfo {
        val nameDay = listOfDays.random()
        val stateWeather = R.drawable.ic_cloudy_sunny
        val minTemperature = Random.nextInt(0, 10)
        val maxTemperature = Random.nextInt(10, 20)

        val day = OneDayInfo(nameDay, stateWeather, minTemperature, maxTemperature)
        return day
    }

    fun generateListOfDays(): MutableList<OneDayInfo>{
        val week = mutableListOf<OneDayInfo>()
        for(day in 0..6) week.add(randomInfoOfDay())
        return week
    }
}