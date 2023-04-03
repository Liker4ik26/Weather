package com.compose.weather.screens.home.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.compose.weather.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    nameCity: String,
    modifier: Modifier = Modifier,
    onTypeCity: (String) -> Unit,
    isError: Boolean,
    onSearchCity: () -> Unit,
    onShare: () -> Unit
) {
    TextField(
        value = nameCity,
        onValueChange = { onTypeCity(it) },
        placeholder = {
            Text(
                text = stringResource(id = R.string.enter_city),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.4F)
            )
        },
        singleLine = true,
        maxLines = 1,
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        leadingIcon = {
            IconButton(onClick = { onShare() }) {
                Icon(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = stringResource(id = R.string.share),
                    modifier = Modifier.size(60.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            errorIndicatorColor = Color.Red,
            errorCursorColor = Color.Red,
            cursorColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            disabledIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            IconButton(onClick = { onSearchCity() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.search),
                    contentDescription = stringResource(id = R.string.share),
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        },
        isError = isError
    )
}