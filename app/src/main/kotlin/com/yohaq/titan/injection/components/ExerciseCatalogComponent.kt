package com.yohaq.titan.injection.components

import com.yohaq.titan.injection.modules.ExerciseCatalogModule
import com.yohaq.titan.ui.views.ExerciseCatalog
import dagger.Component

/**
 * Created by yousufhaque on 6/8/16.
 */
@Component (
        modules = arrayOf(ExerciseCatalogModule::class)
)
interface ExerciseCatalogComponent {

    fun inject(exerciseCatalog: ExerciseCatalog)
}