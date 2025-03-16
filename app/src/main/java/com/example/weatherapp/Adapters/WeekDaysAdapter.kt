package com.example.weatherapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Interfaces.OnDayClickListener
import com.example.weatherapp.Model.OneDayInfo
import com.example.weatherapp.R
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
            minTemperature.text = itemView.context.getString(R.string.temp_format, day.minTemperature)
            maxTemperature.text = itemView.context.getString(R.string.temp_format, day.maxTemperature)

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
    fun updateData(newData: MutableList<OneDayInfo>) {
        daysWeek.clear() // Очистка текущих данных
        daysWeek.addAll(newData) // Добавление новых данных
        notifyDataSetChanged() // Оповещение адаптера о том, что данные изменились
    }

}