package com.yohaq.titan.ui.mainScreen.workoutHistory

import com.yohaq.titan.data.interactors.GetAllWorkoutsInteractor
import com.yohaq.titan.data.models.Workout
import rx.Observable
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
open class WorkoutHistoryViewModel
@Inject
constructor(getAllWorkoutsInteractor: GetAllWorkoutsInteractor) {

        val allWorkoutsObservable: Observable<List<Workout>>

    init {
        allWorkoutsObservable = getAllWorkoutsInteractor.getAllWorkouts()
    }


}