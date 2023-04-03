package com.compose.weather.weather_api.weather.data.remote

import com.compose.weather.core.ErrorReason
import com.compose.weather.core.entity.Either
import com.compose.weather.weather_api.weather.data.remote.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiDataSource {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") q: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String
    ): Either<ErrorReason, WeatherResponse>
}