package com.quansoft.quancast.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
//
//private val DarkColorScheme = darkColorScheme(
//    primary = Color(0xFFBB86FC), // Purple 200
//    onPrimary = Color(0xFF6200EE), // Purple 700
//    secondary = Color(0xFF3700B3), // Teal200,
//    onSecondary =  Color(0xFF03DAC5), // Teal700,
//    background = Color(0xFF121212), // Black,
//    onBackground = Color(0xFFE0E0E0), // White,
//    surface = Color.DarkGray,
//    onSurface = LightGray
//)
//private val LightColorScheme = darkColorScheme(
//    primary = Color(0xFF6200EE), // Purple 700
//    onPrimary = Color(0xFFBB86FC), // Purple 200
//    secondary = Color(0xFF03DAC5), // Teal200
//    onSecondary = Color(0xFF3700B3), // Teal700
//    background = Color(0xFFFFFFFF), // White
//    onBackground = Color(0xFF000000), // Black
//    surface = LightGray,
//    onSurface = Color.DarkGray
//)


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)


private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /*
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
fun QuancastTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}