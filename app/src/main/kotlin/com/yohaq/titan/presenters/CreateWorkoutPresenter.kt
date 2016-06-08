package com.yohaq.titan.presenters

import com.yohaq.titan.data.interactors.CreateWorkoutInteractor
import com.yohaq.titan.presenters.base.BasePresenter
import com.yohaq.titan.ui.views.interfaces.CreateWorkoutView
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateWorkoutPresenter
@Inject constructor(private val createWorkoutInteractor: CreateWorkoutInteractor): BasePresenter<CreateWorkoutView>() {

    fun createWorkout(date : Date) {
        createWorkoutInteractor.createWorkout(date)
    }
}