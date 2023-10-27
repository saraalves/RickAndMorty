package com.saraalves.rickandmorty.presentation.ui.theme

import androidx.compose.ui.graphics.Color

val BlackRickAndMorty = Color(0xFF000000)
val DarkGrey = Color(0x1D1E20)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val colorPrimaryDark = Color(0xFF1D1E20)
val black = Color(0xFF000000)
val colorDetail = Color(0x80FFFFFF)
val white = Color(0xFFFFFFFF)


sealed class ThemeColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val textColorTheme: Color
) {
    object DarkMode : ThemeColors(
        background = BlackRickAndMorty,
        surface = colorPrimaryDark,
        primary = colorDetail,
        textColorTheme = white
    )
    object LightMode : ThemeColors(
        background = white,
        surface = Pink80,
        primary = black,
        textColorTheme = BlackRickAndMorty
    )
}