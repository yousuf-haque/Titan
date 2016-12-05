package com.yohaq.titan.ui.createWorkoutScreen

import com.jakewharton.rxrelay.PublishRelay
import com.yohaq.titan.data.interactors.CreateWorkoutInteractor
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.data.models.WorkoutSet
import rx.Observable
import rx.functions.Action1
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateWorkoutViewModel
@Inject constructor(private val createWorkoutInteractor: CreateWorkoutInteractor) {

    val onDateUpdate : Action1<Date>
    val onExerciseUpdate : Action1<Exercise>
    val onSetListUpdate: Action1<List<WorkoutSet>>
    val onCreateWorkout: Action1<Unit>

    private val dateObservable : Observable<Date>
    private val exerciseObservable : Observable<Exercise>
    private val setListObservable : Observable<List<WorkoutSet>>
    private val createWorkoutObservable : Observable<Unit>

    init {
        val dateRelay = PublishRelay.create<Date>()
        val exerciseRelay = PublishRelay.create<Exercise>()
        val setListRelay = PublishRelay.create<List<WorkoutSet>>()
        val createWorkoutRelay = PublishRelay.create<Unit>()

        onDateUpdate = dateRelay.asAction()
        onExerciseUpdate = exerciseRelay.asAction()
        onSetListUpdate = setListRelay.asAction()
        onCreateWorkout = createWorkoutRelay.asAction()


        dateObservable = dateRelay.asObservable()
        exerciseObservable = exerciseRelay.asObservable()
        setListObservable = setListRelay.asObservable()
        createWorkoutObservable = createWorkoutRelay.asObservable()

    }


    fun createWorkout(dateCreated: Date, exercise: Exercise, sets: List<WorkoutSet>) {
        createWorkoutInteractor.createWorkout(dateCreated, exercise, sets)
    }
}