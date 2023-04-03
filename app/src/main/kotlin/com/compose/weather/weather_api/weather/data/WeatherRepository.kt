package com.compose.weather.weather_api.weather.data

import com.compose.weather.core.ErrorReason
import com.compose.weather.core.entity.Either
import com.compose.weather.weather_api.weather.domain.WeatherDomain

interface WeatherRepository {
    suspend fun getCurrentWeather(cityName: String): Either<ErrorReason, WeatherDomain>
}