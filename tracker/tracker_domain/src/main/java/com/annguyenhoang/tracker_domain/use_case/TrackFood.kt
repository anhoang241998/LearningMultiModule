package com.annguyenhoang.tracker_domain.use_case

import com.annguyenhoang.tracker_domain.model.MealType
import com.annguyenhoang.tracker_domain.model.TrackableFood
import com.annguyenhoang.tracker_domain.model.TrackedFood
import com.annguyenhoang.tracker_domain.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            food = TrackedFood(
                name = food.name,
                carbs = ((food.carbsPer100g * 100f) * amount).roundToInt(),
                protein = ((food.proteinPer100g * 100f) * amount).roundToInt(),
                fat = ((food.fatPer100g * 100f) * amount).roundToInt(),
                calories = ((food.carbsPer100g * 100f) * amount).roundToInt(),
                imageUrl = food.imageUrl,
                date = date,
                amount = amount,
                mealType = mealType
            )
        )
    }
}