package com.yohaq.titan.ui.mainScreen.workoutHistory.workoutHistoryByDate

import com.yohaq.titan.ui.mainScreen.workoutHistory.WorkoutHistoryView
import java.util.*

/**
 * Created by yousufhaque on 7/16/16.
 */
interface WorkoutHistoryByDateView : WorkoutHistoryView {

    fun showDate(date: Date)
}