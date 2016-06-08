package com.yohaq.titan.data.interactors

import com.yohaq.titan.data.WorkoutManager
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateWorkoutInteractor @Inject constructor(private val workoutManager: WorkoutManager) {
    fun createWorkout(createDate : Date) = workoutManager.createWorkout(createDate)
}