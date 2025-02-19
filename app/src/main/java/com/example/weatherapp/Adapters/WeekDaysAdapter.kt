package com.example.weatherapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Fragments.WeekFragment
import com.example.weatherapp.Interfaces.OnDayClickListener
import com.example.weatherapp.OneDayInfo
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentOneDayInfoBinding
import com.example.weatherapp.databinding.LayoutOneDayBinding

class WeekDaysAdapter(
    private var daysWeek: MutableList<OneDayInfo>,
    private val listener: OnDayClickListener
): RecyclerView.Adapter<WeekDaysAdapter.WeekDayHolder>() {

    inner class WeekDayHolder(day: View): RecyclerView.ViewHolder(day){
        val binding = LayoutOneDayBinding.bind(day)

        fun bind (day: OneDayInfo) = with(binding){
            nameDay.text = day.nameDay
            stateWeather.setImageResource(day.stateWeather)
            minTemperature.text = day.minTemperature.toString()
            maxTemperature.text = day.maxTemperature.toString()

            oneDayInfo.setOnClickListener{ listener.oneDayClick(day) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekDayHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_one_day, parent,false)
        return WeekDayHolder(view)
    }

    override fun getItemCount():Int = daysWeek.size

    override fun onBindViewHolder(holder: WeekDayHolder, position: Int) {
        holder.bind(daysWeek[position])
    }
}