package com.yohaq.titan.ui.views.interfaces

import com.yohaq.titan.data.models.Exercise

/**
 * Created by yousufhaque on 6/7/16.
 */
interface ExerciseCatalogView : MvpView {

    fun showExercises(exercises: List<Exercise>)
}