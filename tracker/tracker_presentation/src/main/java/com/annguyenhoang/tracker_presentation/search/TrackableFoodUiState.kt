package com.annguyenhoang.tracker_presentation.search

import com.annguyenhoang.tracker_domain.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)
