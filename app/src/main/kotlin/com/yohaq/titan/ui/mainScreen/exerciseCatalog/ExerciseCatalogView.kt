package com.yohaq.titan.ui.mainScreen.exerciseCatalog

import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.ui.views.interfaces.MvpView

/**
 * Created by yousufhaque on 6/7/16.
 */
interface ExerciseCatalogView : MvpView {

    fun showExercises(exercises: List<Exercise>)
}