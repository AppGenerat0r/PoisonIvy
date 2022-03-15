package com.titus.poisonivy.openweather.models

import com.google.gson.annotations.SerializedName

/**
 * Created by feliperoriz on 1/26/16.
 */
open class OpenWeatherMapBase(@SerializedName("cod") val statusCode: Int)
//    constructor(@SerializedName("cod") statusCode: Int)



