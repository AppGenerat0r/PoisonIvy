package com.titus.poisonivy.openweather.models

import com.google.gson.annotations.SerializedName

/**
 * Created by feliperoriz on 1/26/16.
 */
data class OpenWeatherMapWeather(val id: Int,
                                 @SerializedName("main") var description: String,
                                 @SerializedName("description") var detailedDescription: String,
                                 var icon: String)