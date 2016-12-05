package com.yohaq.titan.ui.mainScreen.workoutHistory

import com.yohaq.titan.data.models.Workout
import com.yohaq.titan.ui.views.interfaces.MvpView

/**
 * Created by yousufhaque on 6/8/16.
 */
interface WorkoutHistoryView : MvpView {

    fun showWorkouts(workouts : List<Workout>)
}