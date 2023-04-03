package com.compose.weather.weather_api.weather.domain

class WeatherDomain(
    val weather: List<CurrentWeatherDomain>,
    val main: MainWeatherDomain,
    val visibility: Int,
    val windSpeed: Double,
    val clouds: Int,
    val name: String
)

class CurrentWeatherDomain(
    val main: String,
    val description: String,
    val icon: String
)

class MainWeatherDomain(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int
)