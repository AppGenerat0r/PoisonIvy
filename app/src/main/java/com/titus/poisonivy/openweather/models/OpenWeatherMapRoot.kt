package com.titus.poisonivy.openweather.models

/**
 * Created by feliperoriz on 1/26/16.
 */
class OpenWeatherMapRoot(var weather: List<OpenWeatherMapWeather>,
                              var main: OpenWeatherMapMain) : OpenWeatherMapBase(0) {

}