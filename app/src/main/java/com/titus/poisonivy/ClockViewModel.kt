package com.titus.poisonivy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.titus.poisonivy.openweather.models.WeatherEntry

class ClockViewModel : ViewModel() {


    val Weather: MutableLiveData<WeatherEntry> = MutableLiveData<WeatherEntry>(WeatherEntry())

}