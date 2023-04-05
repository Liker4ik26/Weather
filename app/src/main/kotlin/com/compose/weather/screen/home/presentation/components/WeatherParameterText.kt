package com.compose.weather.screen.home.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun WeatherParameterText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall
    )
}