package com.yohaq.titan.injection.components

import com.yohaq.titan.injection.modules.RealmModule
import com.yohaq.titan.ui.views.WorkoutHistory
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@Component (
        modules = arrayOf(RealmModule::class)
)
interface WorkoutHistoryComponent {

    fun inject(workoutHistory: WorkoutHistory)
}