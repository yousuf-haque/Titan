package com.yohaq.titan.data.interactors

import com.yohaq.titan.data.ExercisesManager
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class GetAllExercisesInteractor
@Inject
constructor(private val exercisesManager: ExercisesManager) {

    fun getAllExercises() = exercisesManager.getExercises()


}