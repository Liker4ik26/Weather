package com.compose.weather.screen.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.weather.core.entity.map
import com.compose.weather.core.entity.unpack
import com.compose.weather.screen.home.presentation.models.mappers.asWeatherItemUi
import com.compose.weather.weather_api.weather.data.WeatherRepository
import com.compose.weather.weather_api.weather.domain.WeatherDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<HomeUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.OnSearchCity -> {
                viewModelScope.launch { loadSearchResult() }
            }

            is HomeUiEvent.OnTypeCity -> {
                _state.update { it.copy(cityName = event.cityName) }
            }

            is HomeUiEvent.OnShare -> {
                viewModelScope.launch {
                    _effect.emit(HomeUiEffect.ShareWeather)
                }
            }
        }
    }

    private suspend fun loadSearchResult() {
        weatherRepository.getCurrentWeather(_state.value.cityName.trim())
            .map(WeatherDomain::asWeatherItemUi).unpack(
                success = { weather ->
                    _state.update {
                        it.copy(
                            weather = weather,
                            errorMessage = null,
                            isError = false
                        )
                    }
                },
                error = { error ->
                    _state.update {
                        it.copy(
                            weather = null,
                            errorMessage = error.message,
                            isError = true
                        )
                    }
                }
            )
    }
}