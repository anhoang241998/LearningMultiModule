package com.annguyenhoang.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.annguyenhoang.calorietracker.navigation.navigate
import com.annguyenhoang.calorietracker.ui.theme.CalorieTrackerTheme
import com.annguyenhoang.core.navigation.Route
import com.annguyenhoang.onboarding_presentation.gender.GenderScreen
import com.annguyenhoang.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalorieTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ) {
                    composable(Route.WELCOME) {
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.AGE) {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                    composable(Route.GENDER) {
                        GenderScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.HEIGHT) {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                    composable(Route.WEIGHT) {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                    composable(Route.NUTRIENT_GOAL) {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                    composable(Route.ACTIVITY) {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                    composable(Route.GOAL) {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                    composable(Route.TRACKER_OVERVIEW) {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                    composable(Route.SEARCH) {
                        Box(modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
}
