package com.annguyenhoang.calorietracker.navigation

import androidx.navigation.NavController
import com.annguyenhoang.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}