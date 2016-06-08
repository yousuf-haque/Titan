package com.yohaq.titan.data.interactors

import com.yohaq.titan.data.WorkoutManager
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class GetAllWorkoutsInteractor @Inject constructor(private val workoutManager: WorkoutManager){

    fun getAllWorkouts() = workoutManager.getWorkouts()
}