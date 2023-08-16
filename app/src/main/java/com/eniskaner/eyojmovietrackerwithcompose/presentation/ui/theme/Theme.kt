package com.eniskaner.eyojmovietrackerwithcompose.presentation.ui.theme

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

private val darkColorSchemes = darkColorScheme(
    primary = BlueGlitterBanner2,
    onPrimary = OriginalConceptForFilm3,
    onPrimaryContainer = BlueGlitterBanner3,
    primaryContainer = BlueGlitterBanner5,
    inversePrimary = BlueGlitterBanner4,
    secondary = TealAndGray5,
    onSecondary = TealAndGray3,
    onSecondaryContainer = TealAndGray4,
    secondaryContainer = TealAndGray3,
    outlineVariant = Closeup5,
    tertiary = OldFilm3,
    onTertiary = OldFilm2,
    tertiaryContainer = OldFilm1,
    onTertiaryContainer = OldFilm4,
    scrim = OldFilm5,
    background = OriginalConceptForFilm2,
    onBackground = TealAndGray3,
    inverseSurface = OriginalConceptForFilm5,
    inverseOnSurface = OriginalConceptForFilm1,
    outline = OriginalConceptForFilm3,
    surface = BlueGlitterBanner2,
    onSurface = OldFilm4,
    surfaceVariant = OriginalConceptForFilm2,
    onSurfaceVariant = RelativeReality3,
    surfaceTint = Closeup2,
    error = RelativeReality5,
    onError = RelativeReality4,
    errorContainer = RelativeReality3,
    onErrorContainer = RelativeReality1
)

private val lightColorSchemes = lightColorScheme(
    primary = BlueGlitterBanner4,
    onPrimary = BlueGlitterBanner3,
    onPrimaryContainer = BlueGlitterBanner2,
    primaryContainer = BlueGlitterBanner1,
    inversePrimary = BlueGlitterBanner5,
    secondary = TealAndGray3,
    onSecondary = Closeup1,
    onSecondaryContainer = TealAndGray4,
    secondaryContainer = TealAndGray5,
    outlineVariant = Closeup4,
    tertiary = OldFilm5,
    onTertiary = OldFilm1,
    tertiaryContainer = OldFilm3,
    onTertiaryContainer = OldFilm4,
    scrim = OldFilm2,
    background = OriginalConceptForFilm4,
    onBackground = OriginalConceptForFilm2,
    inverseSurface = OriginalConceptForFilm5,
    inverseOnSurface = OriginalConceptForFilm3,
    outline = OriginalConceptForFilm1,
    surface = BlueGlitterBanner4,
    onSurface = OldFilm5,
    surfaceVariant = OriginalConceptForFilm4,
    onSurfaceVariant = RelativeReality2,
    surfaceTint = Closeup4,
    error = RelativeReality5,
    onError = RelativeReality4,
    errorContainer = RelativeReality3,
    onErrorContainer = RelativeReality1,



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
fun EyojMovieTrackerWithComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorSchemes
        else -> lightColorSchemes
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