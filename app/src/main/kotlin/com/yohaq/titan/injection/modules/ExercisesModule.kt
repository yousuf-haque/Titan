package com.yohaq.titan.injection.modules

import com.yohaq.titan.data.interactors.GetAllExercisesInteractor
import dagger.Module
import dagger.Provides

/**
 * Created by yousufhaque on 6/7/16.
 */
@Module
class ExercisesModule {
    @Provides
    fun providesAllExercisesObservable(getAllExercisesInteractor: GetAllExercisesInteractor) =
            getAllExercisesInteractor.getAllExercises()
}