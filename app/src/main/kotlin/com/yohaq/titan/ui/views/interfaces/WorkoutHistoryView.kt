package com.yohaq.titan.ui.views.interfaces

import com.yohaq.titan.data.models.Workout

/**
 * Created by yousufhaque on 6/8/16.
 */
interface WorkoutHistoryView : MvpView {

    fun showWorkouts(workouts : List<Workout>)
}