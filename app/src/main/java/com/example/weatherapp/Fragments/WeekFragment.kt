package com.example.weatherapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.Adapters.WeekDaysAdapter
import com.example.weatherapp.Interfaces.OnDayClickListener
import com.example.weatherapp.Model.OneDayInfo
import com.example.weatherapp.R
import com.example.weatherapp.ViewModel.WeatherViewModel
import com.example.weatherapp.databinding.FragmentWeekInfoBinding


class WeekFragment: Fragment() {
    private lateinit var binding: FragmentWeekInfoBinding
    private lateinit var viewModel: WeatherViewModel
    private lateinit var adapter: WeekDaysAdapter

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

        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        adapter = WeekDaysAdapter(mutableListOf(), object : OnDayClickListener{

            override fun oneDayClick(day: OneDayInfo) {
                val fragment = OneDayFragment().apply {
                    arguments = Bundle().apply { putParcelable("dayInfo", day) }
                }
                parentFragmentManager.beginTransaction().
                replace(R.id.one_day_info, fragment).
                addToBackStack(null).
                commit()
            }
        }
            )
        binding.recyclerViewWeekInfo.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewWeekInfo.adapter = adapter

        observeWeather()
        viewModel.fetchWeather() // Загружаем данные
    }

    private fun observeWeather() {
        viewModel.weatherData.observe(viewLifecycleOwner) { newData ->
            if (newData.isEmpty()) {
                Log.e("WeekFragment", "Нет данных о погоде")
            }
            else {
                adapter.updateData(newData)
                Log.d("WeekFragment", "Данные о погоде обновлены")
            }
        }
    }
}
