package com.titus.poisonivy.openweather.models


data class WeatherEntry(  var currentTemp: Double = 72.0,
                   var low: Double = 60.0, var high: Double = 75.0, var description: String = "Cloudy",
                        var toString: String =
                        "Current: $currentTemp --- Low: $low --- High: $high") {


    override fun toString(): String {
        return toString
    }

    fun changeToString(string: String) {
        toString = string
    }
}
