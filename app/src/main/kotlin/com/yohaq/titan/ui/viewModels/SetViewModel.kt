package com.yohaq.titan.ui.viewModels

import com.yohaq.titan.data.models.WorkoutSet

/**
 * Created by yousufhaque on 6/8/16.
 */
class SetViewModel(val set: WorkoutSet) {

    fun weightToString(): String {
        return "${set.weight.toString()} lbs"
    }

    fun repsToString(): String {
        return "${set.reps.toString()} reps"
    }
}