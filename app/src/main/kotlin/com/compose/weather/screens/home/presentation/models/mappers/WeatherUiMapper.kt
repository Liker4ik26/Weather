package com.compose.weather.screens.home.presentation.models.mappers

import com.compose.weather.screens.home.presentation.models.CurrentWeatherItemUi
import com.compose.weather.screens.home.presentation.models.MainWeatherItemUi
import com.compose.weather.screens.home.presentation.models.WeatherItemUi
import com.compose.weather.weather_api.weather.domain.CurrentWeatherDomain
import com.compose.weather.weather_api.weather.domain.MainWeatherDomain
import com.compose.weather.weather_api.weather.domain.WeatherDomain

fun WeatherDomain.asWeatherItemUi(): WeatherItemUi {

    return WeatherItemUi(
        weather = weather.map(CurrentWeatherDomain::asCurrentWeatherItemUi),
        main = main.asMainWeatherItemUi(),
        visibility = visibility,
        windSpeed = windSpeed,
        clouds = clouds,
        name = name
    )
}

fun CurrentWeatherDomain.asCurrentWeatherItemUi(): CurrentWeatherItemUi {
    return CurrentWeatherItemUi(
        main = main,
        description = description,
        icon = icon
    )
}

fun MainWeatherDomain.asMainWeatherItemUi(): MainWeatherItemUi {
    return MainWeatherItemUi(
        temp = temp,
        feelsLike = feelsLike,
        tempMin = tempMin,
        tempMax = tempMax,
        pressure = pressure,
        humidity = humidity
    )
}