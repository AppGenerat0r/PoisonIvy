package com.titus.poisonivy.openweather.presenter

import com.titus.poisonivy.FullscreenActivity
import com.titus.poisonivy.openweather.models.WeatherEntry
import com.titus.poisonivy.openweather.networking.OpenWeatherMapWrapper


/**
 * Created by feliperoriz on 1/26/16.
 */
class MainPresenterImpl: MainPresenter {

    var view: FullscreenActivity
    var wrapper: OpenWeatherMapWrapper

    constructor(view: FullscreenActivity) {
        this.view = view
        wrapper = OpenWeatherMapWrapper(this)
    }

    override fun setWeatherData(weatherEntry: WeatherEntry) {
        view.setWeatherData(weatherEntry)
    }

    override fun checkWeatherEntry(weatherEntry: WeatherEntry): WeatherEntry {
        val weather: WeatherEntry
        if (weatherEntry == null) {
            weather = WeatherEntry( )
            weather.changeToString("")
            return weather
        }
        return weatherEntry
    }

    override fun makeApiCall(lat:Double, lon:Double) {
        wrapper.getOpenWeatherMapRoot(lat, lon,this);
    }
}
