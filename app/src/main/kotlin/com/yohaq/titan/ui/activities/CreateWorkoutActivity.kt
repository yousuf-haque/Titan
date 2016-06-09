package com.yohaq.titan.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.yohaq.titan.R
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.injection.components.DaggerCreateWorkoutComponent
import com.yohaq.titan.presenters.CreateWorkoutPresenter
import com.yohaq.titan.presenters.ExerciseCatalogPresenter
import com.yohaq.titan.ui.adapters.ExercisesAdapter
import com.yohaq.titan.ui.views.interfaces.CreateWorkoutView
import com.yohaq.titan.ui.views.interfaces.ExerciseCatalogView
import kotlinx.android.synthetic.main.activity_create_workout.*
import java.util.*
import javax.inject.Inject

class CreateWorkoutActivity : AppCompatActivity(), CreateWorkoutView, ExerciseCatalogView {


    companion object {

        fun createIntent(context: Context) =
                Intent(context, CreateWorkoutActivity::class.java)

    }

    @Inject
    lateinit var createWorkoutPresenter: CreateWorkoutPresenter

    @Inject
    lateinit var exerciseCatalogPresenter: ExerciseCatalogPresenter


    @Inject
    lateinit var exercisesAdapter: ExercisesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)
        DaggerCreateWorkoutComponent.create().inject(this)
        choose_exercise_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        exercisesAdapter.onExerciseClick = { exercise -> Toast.makeText(this, "I'm passed in ${exercise.name}", Toast.LENGTH_SHORT).show() }
        choose_exercise_list.adapter = exercisesAdapter
        createWorkoutPresenter.attachView(this)
        exerciseCatalogPresenter.attachView(this)

        create_workout_submit_button.setOnClickListener { handleAddExerciseButtonClick() }
    }

    override fun onDestroy() {
        super.onDestroy()
        createWorkoutPresenter.detachView()
        exerciseCatalogPresenter.detachView()
    }

    private fun handleAddExerciseButtonClick() {
        createWorkoutPresenter.createWorkout(Date())
        finish()
    }

    override fun showExercises(exercises: List<Exercise>) {
        exercisesAdapter.updateExercises(exercises)
    }
}
