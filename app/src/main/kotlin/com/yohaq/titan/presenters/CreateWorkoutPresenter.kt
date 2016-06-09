package com.yohaq.titan.presenters

import com.yohaq.titan.data.interactors.CreateWorkoutInteractor
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.data.models.WorkoutSet
import com.yohaq.titan.presenters.base.BasePresenter
import com.yohaq.titan.ui.views.interfaces.CreateWorkoutView
import io.realm.RealmList
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateWorkoutPresenter
@Inject constructor(private val createWorkoutInteractor: CreateWorkoutInteractor): BasePresenter<CreateWorkoutView>() {

    fun createWorkout(dateCreated: Date, exercise: Exercise, sets: RealmList<WorkoutSet>) {
        createWorkoutInteractor.createWorkout(dateCreated, exercise, sets)
    }
}