package com.compose.weather.screens.home.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp

@Composable
fun WeatherParameterIcon(@DrawableRes icon: Int, @StringRes contentDescription: Int, sizeIcon:Dp) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = stringResource(id = contentDescription),
        tint = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier.size(sizeIcon)
    )
}