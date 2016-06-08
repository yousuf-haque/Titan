package com.yohaq.titan.injection.components

import com.yohaq.titan.injection.modules.CreateWorkoutModule
import com.yohaq.titan.ui.activities.CreateWorkoutActivity
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@Component(
        modules = arrayOf(CreateWorkoutModule::class)
)
interface CreateWorkoutComponent {

    fun inject(createWorkoutActivity: CreateWorkoutActivity)
}