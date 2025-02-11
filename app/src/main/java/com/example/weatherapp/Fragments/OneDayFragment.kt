package com.example.weatherapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.FragmentOneDayInfoBinding

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

    }
}