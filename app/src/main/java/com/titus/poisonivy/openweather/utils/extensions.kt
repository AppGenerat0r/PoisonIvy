package com.titus.poisonivy.openweather.utils

import com.titus.poisonivy.openweather.models.OpenWeatherMapRoot
import com.titus.poisonivy.openweather.models.WeatherEntry

/**
 * Created by feliperoriz on 1/26/16.
 */

fun WeatherEntry.createWeatherEntry(  root: OpenWeatherMapRoot) : WeatherEntry {
    return WeatherEntry(

            root.main.currentTemp,
            root.main.low,
            root.main.max,
            root.weather[0].description
    )

}
