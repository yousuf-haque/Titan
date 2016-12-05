package com.yohaq.titan.ui.mainScreen.exerciseCatalog

import com.yohaq.titan.data.interactors.GetAllExercisesInteractor
import com.yohaq.titan.data.models.Exercise
import rx.Observable
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExerciseCatalogViewModel
@Inject
constructor( getAllExercisesInteractor: GetAllExercisesInteractor)  {
val exercisesObservable : Observable<List<Exercise>>

    init {
        exercisesObservable = getAllExercisesInteractor.getAllExercises()
    }


}