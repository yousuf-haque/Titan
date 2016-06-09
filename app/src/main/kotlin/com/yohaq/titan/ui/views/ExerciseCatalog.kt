package com.yohaq.titan.ui.views

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.widget.Toast
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.injection.components.DaggerExerciseCatalogComponent
import com.yohaq.titan.presenters.ExerciseCatalogPresenter
import com.yohaq.titan.ui.activities.CreateExerciseActivity
import com.yohaq.titan.ui.adapters.ExercisesAdapter
import com.yohaq.titan.ui.views.interfaces.ExerciseCatalogView
import io.realm.Realm
import kotlinx.android.synthetic.main.view_exercises.view.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class ExerciseCatalog(context: Context?, attrs: AttributeSet?) : CoordinatorLayout(context, attrs), ExerciseCatalogView {


    @Inject
    lateinit var exerciseAdapter: ExercisesAdapter

    @Inject
    lateinit var realm: Realm

    @Inject
    lateinit var presenter : ExerciseCatalogPresenter

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        DaggerExerciseCatalogComponent.create().inject(this)
        exercise_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        exerciseAdapter.onExerciseClick = { exercise -> Toast.makeText(context, "I'm passed in ${exercise.name}", Toast.LENGTH_SHORT).show() }
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
        realm.close()
    }

    override fun showExercises(exercises: List<Exercise>) {
        exerciseAdapter.updateExercises(exercises);
    }


}