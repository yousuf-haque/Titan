package com.yohaq.titan.ui.createWorkoutScreen

import com.yohaq.titan.injection.modules.RealmModule
import com.yohaq.titan.injection.scopes.ViewScope
import com.yohaq.titan.ui.createWorkoutScreen.CreateWorkoutActivity
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@ViewScope
@Component(
        modules = arrayOf(RealmModule::class)
)
interface CreateWorkoutComponent {

    fun inject(createWorkoutActivity: CreateWorkoutActivity)
}