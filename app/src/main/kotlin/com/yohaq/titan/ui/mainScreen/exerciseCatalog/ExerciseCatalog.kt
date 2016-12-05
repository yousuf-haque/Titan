package com.yohaq.titan.ui.mainScreen.exerciseCatalog

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.ui.mainScreen.exerciseCatalog.adapters.ExercisesAdapter
import com.yohaq.titan.ui.createExerciseScreen.CreateExerciseActivity
import kotlinx.android.synthetic.main.view_exercises.view.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class ExerciseCatalog(context: Context?, attrs: AttributeSet?) : CoordinatorLayout(context, attrs), ExerciseCatalogView {


    @Inject
    lateinit var exerciseAdapter: ExercisesAdapter


    @Inject
    lateinit var presenter : ExerciseCatalogPresenter

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        DaggerExerciseCatalogComponent.create().inject(this)
        exercise_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        exercise_list.adapter = exerciseAdapter
        add_exercise_button.setOnClickListener { handleCreateExerciseButtonClick() }
        presenter.attachView(this)

    }

    private fun handleCreateExerciseButtonClick() {
        context.startActivity(CreateExerciseActivity.createIntent(context))
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
    }

    override fun showExercises(exercises: List<Exercise>) {
        exerciseAdapter.updateExercises(exercises);
    }


}