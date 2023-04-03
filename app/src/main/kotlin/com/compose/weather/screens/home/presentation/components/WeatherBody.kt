package com.compose.weather.screens.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compose.weather.R
import com.compose.weather.screens.home.presentation.models.WeatherItemUi
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun WeatherBody(
    weather: WeatherItemUi?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = stringResource(id = R.string.right_now),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.tertiary
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = weather?.weather?.get(0)?.description?.replaceFirstChar { char ->
                if (char.isLowerCase())
                    char.titlecase(Locale.ROOT) else char.toString()
            } ?: stringResource(id = R.string.empty),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            ImageWithPlaceHolder(
                image = weather?.weather?.get(0)?.icon ?: stringResource(id = R.string.empty),
                modifier = Modifier
                    .size(140.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = "${weather?.main?.temp?.roundToInt() ?: stringResource(id = R.string.empty)} °C",
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    ),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "${
                        LocalContext.current.getString(
                            R.string.feels_like,
                            weather?.main?.feelsLike?.roundToInt() ?: stringResource(id = R.string.empty)
                        )
                    } °C",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(25.dp))
                TempCard(
                    minTemp = "${weather?.main?.tempMin?.roundToInt() ?: stringResource(id = R.string.empty)} °C",
                    maxTemp = "${weather?.main?.tempMax?.roundToInt() ?: stringResource(id = R.string.empty)} °C"
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PressureCard(pressure = "${weather?.main?.pressure ?: stringResource(id = R.string.empty)} hPa")
            Spacer(modifier = Modifier.width(30.dp))
            WindCard(wind = "${weather?.windSpeed ?: stringResource(id = R.string.empty)}")
            Spacer(modifier = Modifier.width(30.dp))
            HumidityCard(humidity = "${weather?.main?.humidity ?: stringResource(id = R.string.empty)} %")
        }
        Spacer(modifier = Modifier.height(30.dp))
        CloudsCard(clouds = "${weather?.clouds ?: stringResource(id = R.string.empty)}")
    }
}