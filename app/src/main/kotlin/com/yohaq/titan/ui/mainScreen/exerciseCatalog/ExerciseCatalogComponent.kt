package com.yohaq.titan.ui.mainScreen.exerciseCatalog

import com.yohaq.titan.injection.modules.RealmModule
import com.yohaq.titan.injection.scopes.ViewScope
import com.yohaq.titan.ui.mainScreen.exerciseCatalog.ExerciseCatalog
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@ViewScope
@Component(
        modules = arrayOf(RealmModule::class)
)
interface ExerciseCatalogComponent {

    fun inject(exerciseCatalog: ExerciseCatalog)
}