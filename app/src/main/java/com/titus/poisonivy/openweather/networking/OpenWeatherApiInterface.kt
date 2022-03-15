package com.titus.poisonivy.openweather.networking

import com.titus.poisonivy.openweather.presenter.MainPresenter


/**
 * Created by feliperoriz on 1/26/16.
 */
interface OpenWeatherApiInterface {
    fun getOpenWeatherMapRoot(lat:Double, lon:Double, presenter: MainPresenter)
}