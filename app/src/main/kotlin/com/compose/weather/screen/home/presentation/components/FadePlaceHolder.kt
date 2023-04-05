package com.compose.weather.screen.home.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun FadePlaceHolder(modifier: Modifier) {
    Box(
        modifier = modifier.placeholder(
            visible = true,
            color = Color.LightGray,
            highlight = PlaceholderHighlight.fade()
        )
    )
}