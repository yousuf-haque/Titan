package com.yohaq.titan.data.interactors

import com.yohaq.titan.data.WorkoutManager
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.data.models.WorkoutSet
import io.realm.RealmList
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateWorkoutInteractor @Inject constructor(private val workoutManager: WorkoutManager) {
    fun createWorkout(dateCreated: Date, exercise: Exercise, sets: RealmList<WorkoutSet>) = workoutManager.createWorkout(dateCreated, exercise, sets)
}