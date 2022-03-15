package com.titus.poisonivy.openweather.networking

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.titus.poisonivy.openweather.models.OpenWeatherMapRoot
import com.titus.poisonivy.openweather.models.WeatherEntry
import com.titus.poisonivy.openweather.presenter.MainPresenter
import com.titus.poisonivy.openweather.utils.createWeatherEntry

import retrofit.Callback
import retrofit.RestAdapter
import retrofit.RetrofitError
import retrofit.client.Response
import retrofit.converter.GsonConverter

/**
 * Wrapper for interacting with the Open Weather API.
 * Created by Felipe Roriz on 1/26/16.
 */
class OpenWeatherMapWrapper : OpenWeatherApiInterface {

    val apiKey = "6c66057b32a8b75d0ffb56b9263adb25"

    val unitType = "imperial"

    var presenter: MainPresenter
    var openWeatherApi: OpenWeatherApi
    var gsonBuilder: GsonBuilder
    var gson: Gson
    var weatherRestAdapter: RestAdapter

    constructor(presenter: MainPresenter) {
        this.presenter = presenter

        gsonBuilder = GsonBuilder()
        gson = gsonBuilder.create()

        weatherRestAdapter = RestAdapter.Builder()
                .setEndpoint("http://api.openweathermap.org/")

                .setConverter(GsonConverter(gson))
                .build()

        openWeatherApi = weatherRestAdapter.create(OpenWeatherApi::class.java)
    }


    override fun getOpenWeatherMapRoot(lat:Double, lon:Double, presenter: MainPresenter) {
        openWeatherApi.getWeatherFromApi( apiKey, lat,lon, object: Callback<OpenWeatherMapRoot> {
            override fun success(root: OpenWeatherMapRoot?, response: Response?) {
                var weatherEntry : WeatherEntry?
                if (root != null && root.statusCode != 404) {
                    weatherEntry = WeatherEntry().createWeatherEntry( root)
                    presenter.setWeatherData(weatherEntry)
                }
            }
            override fun failure(error: RetrofitError?) {
                Log.d("WEATHER_WRAPPER_DEBUG", error.toString());
            }
        })
    }
}


