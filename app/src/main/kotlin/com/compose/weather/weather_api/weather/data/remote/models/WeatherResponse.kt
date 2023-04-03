package com.compose.weather.weather_api.weather.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class WeatherResponse(
    @Json(name = "weather")
    val weather: List<CurrentWeatherResponse>,
    @Json(name = "main")
    val main: MainWeatherResponse,
    @Json(name = "visibility")
    val visibility: Int,
    @Json(name = "wind")
    val windSpeed: WindWeatherResponse,
    @Json(name = "clouds")
    val clouds: CloudsWeatherResponse,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
class WindWeatherResponse(
    @Json(name = "speed")
    val speed: Double
)

@JsonClass(generateAdapter = true)
class CloudsWeatherResponse(
    @Json(name = "all")
    val all: Int
)

@JsonClass(generateAdapter = true)
class MainWeatherResponse(
    @Json(name = "temp")
    val temp: Double,
    @Json(name = "feels_like")
    val feelsLike: Double,
    @Json(name = "temp_min")
    val tempMin: Double,
    @Json(name = "temp_max")
    val tempMax: Double,
    @Json(name = "pressure")
    val pressure: Int,
    @Json(name = "humidity")
    val humidity: Int
)

@JsonClass(generateAdapter = true)
class CurrentWeatherResponse(
    @Json(name = "main")
    val main: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "icon")
    val icon: String
)