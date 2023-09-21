package com.saraalves.rickandmorty.presentation.character.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.saraalves.rickandmorty.presentation.ui.theme.Pink40
import com.saraalves.rickandmorty.presentation.ui.theme.Pink80
import com.saraalves.rickandmorty.presentation.ui.theme.Purple40
import com.saraalves.rickandmorty.presentation.ui.theme.Purple80
import com.saraalves.rickandmorty.presentation.ui.theme.PurpleGrey40
import com.saraalves.rickandmorty.presentation.ui.theme.PurpleGrey80
import com.saraalves.rickandmorty.presentation.ui.theme.Typography

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun RickAndMortyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if(darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }


    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}