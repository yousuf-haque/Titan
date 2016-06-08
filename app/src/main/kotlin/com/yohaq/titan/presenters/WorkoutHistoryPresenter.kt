package com.yohaq.titan.presenters

import com.yohaq.titan.data.interactors.GetAllWorkoutsInteractor
import com.yohaq.titan.presenters.base.BasePresenter
import com.yohaq.titan.ui.views.interfaces.WorkoutHistoryView
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class WorkoutHistoryPresenter

@Inject
constructor(private val getAllWorkoutsInteractor: GetAllWorkoutsInteractor)
: BasePresenter<WorkoutHistoryView>() {

    override fun subscribe() {
        super.subscribe()
        subscriptions?.add(getAllWorkoutsInteractor.getAllWorkouts().subscribe{view?.showWorkouts(it)})

    }
}