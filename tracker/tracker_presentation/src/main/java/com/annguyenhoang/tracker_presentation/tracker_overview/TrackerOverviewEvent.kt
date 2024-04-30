package com.annguyenhoang.tracker_presentation.tracker_overview

import com.annguyenhoang.tracker_domain.model.TrackedFood

sealed class TrackerOverviewEvent {
    data object OnNextDayClick : TrackerOverviewEvent()
    data object OnPreviousDayClick : TrackerOverviewEvent()
    data class OnToggleMealClick(val meal: Meal): TrackerOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()
}