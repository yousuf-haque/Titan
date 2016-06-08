package com.yohaq.titan.injection.components

import com.yohaq.titan.injection.modules.CreateExerciseModule
import com.yohaq.titan.ui.activities.CreateExerciseActivity
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@Component(
        modules = arrayOf(CreateExerciseModule::class)
)
interface CreateExerciseComponent {

    fun inject(createExerciseActivity: CreateExerciseActivity)
}