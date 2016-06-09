package com.yohaq.titan.injection.components

import com.yohaq.titan.injection.modules.RealmModule
import com.yohaq.titan.injection.scopes.ActivityScope
import com.yohaq.titan.ui.views.ExerciseCatalog
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@ActivityScope
@Component (
        modules = arrayOf(RealmModule::class)
)
interface ExerciseCatalogComponent {

    fun inject(exerciseCatalog: ExerciseCatalog)
}