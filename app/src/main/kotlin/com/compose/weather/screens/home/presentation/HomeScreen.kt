package com.compose.weather.screens.home.presentation

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.weather.R
import com.compose.weather.screens.home.presentation.components.SearchField
import com.compose.weather.screens.home.presentation.components.WeatherBody
import com.ramcosta.composedestinations.annotation.Destination
import java.util.Locale
import kotlin.math.roundToInt

@Destination
@Composable
fun HomeScreen() {
    HomeScreen(viewModel = hiltViewModel())
}

@Composable
private fun HomeScreen(viewModel: HomeViewModel) {

    val context = LocalContext.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect() { effect ->
            when (effect) {
                is HomeUiEffect.ShareWeather -> {
                    startActivity(
                        context,
                        Intent.createChooser(
                            Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(
                                    Intent.EXTRA_TEXT,
                                    "${context.getString(R.string.in_city)} ${
                                        state.cityName.replaceFirstChar { char ->
                                            if (char.isLowerCase())
                                                char.titlecase(Locale.ROOT) else char.toString()
                                        }
                                    } ${context.getString(R.string.temperature)} ${state.weather?.main?.temp?.roundToInt()} °C"
                                )
                                type = "text/plan"
                            },
                            context.getString(R.string.current_weather)
                        ),
                        null
                    )
                }
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        WeatherBody(
            weather = state.weather,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        SearchField(
            modifier = Modifier.fillMaxWidth(),
            nameCity = state.cityName,
            isError = state.isError,
            onSearchCity = {
                viewModel.sendEvent(HomeUiEvent.OnSearchCity)
                if (state.isError) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.incorrect_text),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            onTypeCity = {
                viewModel.sendEvent(HomeUiEvent.OnTypeCity(it))
            },
            onShare = {
                viewModel.sendEvent(HomeUiEvent.OnShare)
            }
        )
    }
}