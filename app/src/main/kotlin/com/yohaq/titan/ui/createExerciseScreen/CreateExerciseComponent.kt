package com.yohaq.titan.ui.createExerciseScreen

import com.yohaq.titan.injection.modules.RealmModule
import com.yohaq.titan.injection.scopes.ViewScope
import com.yohaq.titan.ui.createExerciseScreen.CreateExerciseActivity
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@ViewScope
@Component(
        modules = arrayOf(RealmModule::class)
)
interface CreateExerciseComponent {

    fun inject(createExerciseActivity: CreateExerciseActivity)
}