package com.yohaq.titan.presenters

import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.presenters.base.BasePresenter
import com.yohaq.titan.ui.views.interfaces.ExerciseCatalogView
import rx.Observable
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExerciseCatalogPresenter
@Inject
constructor(private val allExercisesObservable: Observable<List<Exercise>>) : BasePresenter<ExerciseCatalogView>() {

    override fun subscribe() {
        super.subscribe()
        subscriptions?.add(allExercisesObservable.subscribe({ view?.showExercises(it)}))
    }


}