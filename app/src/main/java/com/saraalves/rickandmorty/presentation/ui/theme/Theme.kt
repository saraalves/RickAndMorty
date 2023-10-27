package com.saraalves.rickandmorty.presentation.ui.theme

import android.database.AbstractWindowedCursor
import android.view.View
import android.view.Window
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb

private val DarkColorScheme = darkColorScheme(
    background = ThemeColors.DarkMode.background,
    onPrimary = ThemeColors.DarkMode.textColorTheme,
    surface = ThemeColors.DarkMode.surface,
    primary = ThemeColors.DarkMode.primary
)

private val LightColorScheme = lightColorScheme(
    background = ThemeColors.LightMode.background,
    onPrimary = ThemeColors.LightMode.textColorTheme,
    surface = ThemeColors.LightMode.surface,
    primary = ThemeColors.LightMode.primary
)

@Composable
fun RickAndMortyTheme(
    windows: Window,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = Typography,
        colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme
    ) {
        windows.statusBarColor = MaterialTheme.colorScheme.surface.toArgb()
        content()
    }
}

@Composable
fun SystemUi(
    windows: Window,
) {
    MaterialTheme {
        windows.statusBarColor = MaterialTheme.colorScheme.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colorScheme.surface.toArgb()

        @Suppress("DEPRECATION")
        if (MaterialTheme.colorScheme.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        @Suppress("DEPRECATION")
        if (MaterialTheme.colorScheme.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
    }
}