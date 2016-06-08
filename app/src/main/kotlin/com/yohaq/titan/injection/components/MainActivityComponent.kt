package com.yohaq.titan.injection.components

import com.yohaq.titan.injection.modules.ExercisesModule
import com.yohaq.titan.injection.scopes.ActivityScope
import com.yohaq.titan.ui.activities.MainActivity
import dagger.Component

/**
 * Created by yousufhaque on 6/7/16.
 */
@ActivityScope
@Component (
        modules = arrayOf(ExercisesModule::class)
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}