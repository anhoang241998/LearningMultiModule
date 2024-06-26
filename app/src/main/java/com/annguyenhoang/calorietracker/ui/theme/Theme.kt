package com.annguyenhoang.calorietracker.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.annguyenhoang.core_ui.BrightGreen
import com.annguyenhoang.core_ui.DarkGray
import com.annguyenhoang.core_ui.DarkGreen
import com.annguyenhoang.core_ui.Dimensions
import com.annguyenhoang.core_ui.LightGray
import com.annguyenhoang.core_ui.LocalSpacing
import com.annguyenhoang.core_ui.MediumGray
import com.annguyenhoang.core_ui.Orange
import com.annguyenhoang.core_ui.TextWhite

private val DarkColorScheme = darkColorScheme(
    primary = BrightGreen,
    secondary = DarkGreen,
    tertiary = Orange,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LightGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = BrightGreen,
    secondary = DarkGreen,
    tertiary = Orange,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

@Composable
fun CalorieTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
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

    CompositionLocalProvider(
        LocalSpacing provides Dimensions()
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}