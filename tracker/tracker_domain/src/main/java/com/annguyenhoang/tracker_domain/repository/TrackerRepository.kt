package com.annguyenhoang.tracker_domain.repository

import com.annguyenhoang.tracker_domain.model.TrackedFood
import com.annguyenhoang.tracker_domain.model.TrackableFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {
    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)
    suspend fun deleteTrackedFood(food: TrackedFood)
    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}