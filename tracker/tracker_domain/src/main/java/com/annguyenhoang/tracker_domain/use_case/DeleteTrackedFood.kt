package com.annguyenhoang.tracker_domain.use_case

import com.annguyenhoang.tracker_domain.model.TrackedFood
import com.annguyenhoang.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}