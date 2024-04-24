package com.annguyenhoang.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.annguyenhoang.calorietracker.ui.theme.CalorieTrackerTheme
import com.annguyenhoang.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalorieTrackerTheme {
                WelcomeScreen()
            }
        }
    }
}
