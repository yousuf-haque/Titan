package com.yohaq.titan.ui.mainScreen.workoutHistory.adapters

import com.yohaq.titan.data.models.Workout

/**
 * Created by yousufhaque on 6/8/16.
 */
class WorkoutViewModel (val workout: Workout){

    fun numSets() = "${workout.sets.size} Sets"
}