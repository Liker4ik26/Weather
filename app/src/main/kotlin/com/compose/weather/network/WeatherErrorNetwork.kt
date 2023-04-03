package com.compose.weather.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class WeatherErrorNetwork(
    @Json(name = "cod")
    val code: String,
    @Json(name = "message")
    val message: String
)