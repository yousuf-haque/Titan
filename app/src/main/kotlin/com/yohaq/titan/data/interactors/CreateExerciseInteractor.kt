package com.yohaq.titan.data.interactors

import com.yohaq.titan.data.ExercisesManager
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateExerciseInteractor
@Inject constructor(private val exercisesManager: ExercisesManager) {

    fun createExercise(name: String) {
        exercisesManager.createExercise(name)
    }
}