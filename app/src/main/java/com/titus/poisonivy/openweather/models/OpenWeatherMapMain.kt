package com.titus.poisonivy.openweather.models

import com.google.gson.annotations.SerializedName

/**
 * Created by feliperoriz on 1/26/16.
 */
data class OpenWeatherMapMain(@SerializedName("temp") var currentTemp: Double,
                              var pressure: Double,
                              var humidity: Double,
                              @SerializedName("temp_min") var low: Double,
                              @SerializedName("temp_max") var max: Double)