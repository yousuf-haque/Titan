package com.yohaq.titan.ui.createWorkoutScreen

import com.yohaq.titan.data.interactors.CreateWorkoutInteractor
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.data.models.WorkoutSet
import com.yohaq.titan.presenters.base.BasePresenter
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateWorkoutPresenter
@Inject constructor(private val createWorkoutInteractor: CreateWorkoutInteractor): BasePresenter<CreateWorkoutView>() {

    fun createWorkout(dateCreated: Date, exercise: Exercise, sets: List<WorkoutSet>) {
        createWorkoutInteractor.createWorkout(dateCreated, exercise, sets)
    }
}