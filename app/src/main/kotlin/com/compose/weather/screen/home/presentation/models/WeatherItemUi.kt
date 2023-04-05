package com.compose.weather.screen.home.presentation.models

class WeatherItemUi(
    val weather: List<CurrentWeatherItemUi>,
    val main: MainWeatherItemUi,
    val visibility: Int,
    val windSpeed: Double,
    val clouds: Int,
    val name: String
)

class CurrentWeatherItemUi(
    val main: String,
    val description: String,
    val icon: String
)

class MainWeatherItemUi(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int
)