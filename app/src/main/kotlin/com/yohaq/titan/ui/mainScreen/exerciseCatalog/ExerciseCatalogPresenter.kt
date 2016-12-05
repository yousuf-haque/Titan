package com.yohaq.titan.ui.mainScreen.exerciseCatalog

import com.yohaq.titan.data.interactors.GetAllExercisesInteractor
import com.yohaq.titan.presenters.base.BasePresenter
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExerciseCatalogPresenter
@Inject
constructor(private val getAllExercisesInteractor: GetAllExercisesInteractor) : BasePresenter<ExerciseCatalogView>() {

    override fun subscribe() {
        super.subscribe()
        subscriptions?.add(getAllExercisesInteractor.getAllExercises().subscribe({ view?.showExercises(it) }))
    }


}