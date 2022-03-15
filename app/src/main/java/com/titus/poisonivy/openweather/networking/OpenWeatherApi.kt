package com.titus.poisonivy.openweather.networking


import com.titus.poisonivy.openweather.models.OpenWeatherMapRoot
import retrofit.Callback;
import retrofit.http.Query;
import retrofit.http.GET

/**
 * Created by feliperoriz on 1/26/16.
 */
interface OpenWeatherApi {

    @GET("/data/2.5/weather")
    fun getWeatherFromApi(

            @Query("APPID") apiKey: String,
            @Query("lat") lat: Double,
            @Query("lat") lon: Double,
            callback: Callback<OpenWeatherMapRoot>)
}