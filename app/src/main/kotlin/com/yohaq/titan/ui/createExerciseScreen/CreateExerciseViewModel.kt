package com.yohaq.titan.ui.createExerciseScreen

import com.jakewharton.rxrelay.PublishRelay
import com.yohaq.titan.data.interactors.CreateExerciseInteractor
import rx.Observable
import rx.functions.Action1
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class CreateExerciseViewModel
@Inject
constructor(private val createExerciseInteractor: CreateExerciseInteractor) {

    val onNameUpdate : Action1<CharSequence>
    val onCreateExercise : Action1<Unit>

    val nameObservable : Observable<CharSequence>
    val createExerciseObservable : Observable<Unit>

    init {
        val nameRelay = PublishRelay.create<CharSequence>()
        val createExerciseRelay = PublishRelay.create<Unit>()

        onNameUpdate = nameRelay.asAction()
        onCreateExercise = createExerciseRelay.asAction()

        nameObservable = nameRelay.asObservable()
        createExerciseObservable = createExerciseRelay.asObservable()
    }


    fun createExercise(name: String) {
        createExerciseInteractor.createExercise(name)
    }
}