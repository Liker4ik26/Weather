package com.compose.weather.weather_api.weather.data

import android.content.Context
import com.compose.weather.core.ErrorReason
import com.compose.weather.core.entity.Either
import com.compose.weather.core.entity.map
import com.compose.weather.weather_api.weather.data.remote.WeatherApiDataSource
import com.compose.weather.weather_api.weather.data.remote.models.WeatherResponse
import com.compose.weather.weather_api.weather.data.remote.models.mappers.toWeather
import com.compose.weather.weather_api.weather.domain.WeatherDomain
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context,
    private val weatherApiDataSource: WeatherApiDataSource,
) : WeatherRepository {

    private val lang = context.resources.configuration.locales[0].country

    override suspend fun getCurrentWeather(cityName: String): Either<ErrorReason, WeatherDomain> {
        return weatherApiDataSource.getCurrentWeather(
            q = cityName,
            lang = lang,
        ).map(WeatherResponse::toWeather)
    }
}