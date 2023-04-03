package com.compose.weather.screens.home.presentation

import com.compose.weather.screens.home.presentation.models.WeatherItemUi
import javax.annotation.concurrent.Immutable

@Immutable
data class HomeUiState(
    val errorMessage: String? = null,
    val isError: Boolean = false,
    val cityName: String = "",
    val weather: WeatherItemUi? = null
) {
    companion object {
        val Empty = HomeUiState()
    }
}

sealed class HomeUiEvent {
    object OnSearchCity : HomeUiEvent()
    object OnShare: HomeUiEvent()
    class OnTypeCity(val cityName: String) : HomeUiEvent()
}

sealed class HomeUiEffect {
    object ShareWeather: HomeUiEffect()
}