package com.yohaq.titan.presenters

import com.yohaq.titan.data.interactors.GetAllExercisesInteractor
import com.yohaq.titan.presenters.base.BasePresenter
import com.yohaq.titan.ui.views.interfaces.ExerciseCatalogView
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExerciseCatalogPresenter @Inject constructor(val getAllExercisesInteractor: GetAllExercisesInteractor) : BasePresenter<ExerciseCatalogView>() {

    override fun attachView(view: ExerciseCatalogView) {
        super.attachView(view)
        view.showExercises(getAllExercisesInteractor.getAllExercises())
    }
}