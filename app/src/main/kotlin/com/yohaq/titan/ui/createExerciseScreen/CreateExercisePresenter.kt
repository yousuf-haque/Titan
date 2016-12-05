package com.yohaq.titan.ui.createExerciseScreen

import com.yohaq.titan.data.interactors.CreateExerciseInteractor
import com.yohaq.titan.presenters.base.BasePresenter
import com.yohaq.titan.ui.createExerciseScreen.CreateExerciseView
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateExercisePresenter
@Inject
constructor(private val createExerciseInteractor: CreateExerciseInteractor) : BasePresenter<CreateExerciseView>() {


    fun createExercise(name: String) {
        createExerciseInteractor.createExercise(name)
    }
}