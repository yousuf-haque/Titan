package com.yohaq.titan.presenters

import com.yohaq.titan.data.interactors.GetAllWorkoutsInteractor
import com.yohaq.titan.presenters.base.BasePresenter
import com.yohaq.titan.ui.views.interfaces.WorkoutHistoryByDateView
import javax.inject.Inject

/**
 * Created by yousufhaque on 7/16/16.
 */
class WorkoutHistoryByDatePresenter @Inject constructor(getAllWorkoutsInteractor: GetAllWorkoutsInteractor) : BasePresenter<WorkoutHistoryByDateView>() {
}