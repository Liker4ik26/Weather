package com.compose.weather.screens.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compose.weather.R

@Composable
fun PressureCard(pressure: String) {
    Column {
        Row {
            WeatherParameterIcon(
                icon = R.drawable.pressure,
                contentDescription = R.string.pressure,
                sizeIcon = 30.dp
            )
            Spacer(modifier = Modifier.width(10.dp))
            WeatherParameterText(text = pressure)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            WeatherParameterText(text = stringResource(id = R.string.pressure))
        }
    }
}