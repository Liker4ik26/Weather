package com.compose.weather.screens.home.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.compose.weather.R

@Composable
fun ImageWithPlaceHolder(
    image: String,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://openweathermap.org/img/wn/$image@4x.png")
            .crossfade(true)
            .build(),
        contentDescription = stringResource(id = R.string.weather_image),
        modifier = modifier,
        contentScale = ContentScale.Crop
    ) {
        when (painter.state) {
            AsyncImagePainter.State.Empty -> {
                FadePlaceHolder(modifier = modifier.fillMaxSize())
            }

            is AsyncImagePainter.State.Loading -> {
                FadePlaceHolder(modifier = modifier.fillMaxSize())
            }

            is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()

            is AsyncImagePainter.State.Error -> {
                ErrorImage(modifier = Modifier.fillMaxSize())
            }
        }
    }
}