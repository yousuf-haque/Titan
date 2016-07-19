package com.yohaq.titan.injection.components

import com.yohaq.titan.injection.modules.RealmModule
import com.yohaq.titan.injection.scopes.ViewScope
import com.yohaq.titan.ui.fragments.WorkoutHistoryFragment
import com.yohaq.titan.ui.views.WorkoutHistory
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@ViewScope
@Component (
        modules = arrayOf(RealmModule::class)
)
interface WorkoutHistoryComponent {

    fun inject(workoutHistory: WorkoutHistory)
    fun inject(workoutHistory: WorkoutHistoryFragment)
}