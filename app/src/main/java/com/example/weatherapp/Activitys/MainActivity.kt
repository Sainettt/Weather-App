package com.example.weatherapp.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.Fragments.OneDayFragment
import com.example.weatherapp.Fragments.WeekFragment
import com.example.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            supportFragmentManager.beginTransaction().
            replace(oneDayInfo.id, OneDayFragment()).
            commit()

            supportFragmentManager.beginTransaction().
            replace(weekInfo.id, WeekFragment()).
            commit()
        }
    }

}