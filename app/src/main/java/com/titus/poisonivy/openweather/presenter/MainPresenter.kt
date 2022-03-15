package com.titus.poisonivy.openweather.presenter

import com.titus.poisonivy.openweather.models.WeatherEntry


/**
 * Created by feliperoriz on 1/26/16.
 */
interface MainPresenter {
    fun setWeatherData(weatherEntry: WeatherEntry)
    fun checkWeatherEntry(weatherEntry: WeatherEntry) : WeatherEntry
    fun makeApiCall(lat:Double, lon:Double)
}