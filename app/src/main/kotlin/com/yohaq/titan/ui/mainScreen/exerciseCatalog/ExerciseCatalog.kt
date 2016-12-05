package com.yohaq.titan.ui.mainScreen.exerciseCatalog

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import com.yohaq.titan.ui.createExerciseScreen.CreateExerciseActivity
import com.yohaq.titan.ui.mainScreen.exerciseCatalog.adapters.ExercisesAdapter
import kotlinx.android.synthetic.main.view_exercises.view.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class ExerciseCatalog(context: Context?, attrs: AttributeSet?) : CoordinatorLayout(context, attrs) {


    @Inject
    lateinit var exerciseAdapter: ExercisesAdapter


    @Inject
    lateinit var presenter : ExerciseCatalogViewModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        DaggerExerciseCatalogComponent.create().inject(this)
        exercise_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        exercise_list.adapter = exerciseAdapter
        exerciseAdapter.bindObservable(presenter.exercisesObservable).bindToLifecycle(this).subscribe()
        add_exercise_button.setOnClickListener { handleCreateExerciseButtonClick() }

    }

    private fun handleCreateExerciseButtonClick() {
        context.startActivity(CreateExerciseActivity.createIntent(context))
    }





}