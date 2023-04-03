package com.compose.weather.weather_api.weather.data.remote.models.mappers

import com.compose.weather.weather_api.weather.data.remote.models.CurrentWeatherResponse
import com.compose.weather.weather_api.weather.data.remote.models.MainWeatherResponse
import com.compose.weather.weather_api.weather.data.remote.models.WeatherResponse
import com.compose.weather.weather_api.weather.domain.CurrentWeatherDomain
import com.compose.weather.weather_api.weather.domain.MainWeatherDomain
import com.compose.weather.weather_api.weather.domain.WeatherDomain

fun WeatherResponse.toWeather(): WeatherDomain {
    return WeatherDomain(
        weather = weather.map(CurrentWeatherResponse::toCurrentWeather),
        windSpeed = windSpeed.speed,
        main = main.toMainWeather(),
        visibility = visibility,
        clouds = clouds.all,
        name = name
    )
}

fun CurrentWeatherResponse.toCurrentWeather(): CurrentWeatherDomain {
    return CurrentWeatherDomain(
        main = main,
        description = description,
        icon = icon
    )
}

fun MainWeatherResponse.toMainWeather(): MainWeatherDomain {
    return MainWeatherDomain(
        temp = temp,
        feelsLike = feelsLike,
        tempMin = tempMin,
        tempMax = tempMax,
        pressure = pressure,
        humidity = humidity
    )
}