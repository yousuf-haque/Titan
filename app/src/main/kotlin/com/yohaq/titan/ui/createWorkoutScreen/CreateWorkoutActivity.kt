package com.yohaq.titan.ui.createWorkoutScreen

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.yohaq.titan.R
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.data.models.WorkoutSet
import com.yohaq.titan.databinding.ExerciseItemBinding
import com.yohaq.titan.databinding.WorkoutSetItemBinding
import com.yohaq.titan.ui.mainScreen.exerciseCatalog.ExerciseCatalogPresenter
import com.yohaq.titan.ui.mainScreen.exerciseCatalog.ExerciseCatalogView
import com.yohaq.titan.ui.mainScreen.exerciseCatalog.adapters.ExerciseViewModel
import com.yohaq.titan.ui.mainScreen.exerciseCatalog.adapters.ExercisesAdapter
import kotlinx.android.synthetic.main.activity_create_workout.*
import java.util.*
import javax.inject.Inject

class CreateWorkoutActivity : AppCompatActivity(), CreateWorkoutView, ExerciseCatalogView {

    //TODO Implement state retention of added sets on config change

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

    var selectedExercise: Exercise? = null

    var sets : MutableList<WorkoutSet> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)

        DaggerCreateWorkoutComponent.create().inject(this)

        choose_exercise_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        exercisesAdapter.onExerciseClick = { exercise -> handleExerciseSelection(exercise) }
        choose_exercise_list.adapter = exercisesAdapter


        selected_exercise.setOnClickListener { handleExerciseDeselection() }

        create_workout_submit_button.setOnClickListener { handleAddExerciseButtonClick() }

        add_set_button.setOnClickListener { handleAddSetButtonClick() }

        handleExerciseDeselection()


        createWorkoutPresenter.attachView(this)
        exerciseCatalogPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        createWorkoutPresenter.detachView()
        exerciseCatalogPresenter.detachView()
    }


    private fun handleAddSetButtonClick() {
        var newSet = WorkoutSet(
                weight = input_weight.text.toString().toFloat(),
                reps = input_reps.text.toString().toInt())
        var workoutSetItemBinding = DataBindingUtil.inflate<WorkoutSetItemBinding>(layoutInflater, R.layout.workout_set_item, workout_set_list, true)

        //Seems like an IDE bug: https://youtrack.jetbrains.com/issue/KT-12402
        @Suppress("MISSING_DEPENDENCY_CLASS")
        workoutSetItemBinding.viewModel = SetViewModel(newSet)

        sets.add(newSet)


    }

    private fun clearSetInputs() {
        input_weight.setText("")
        input_reps.setText("")
    }

    private fun handleAddExerciseButtonClick() {

        createWorkoutPresenter.createWorkout(Date(), selectedExercise!!, sets)
        finish()
    }

    override fun showExercises(exercises: List<Exercise>) {
        exercisesAdapter.updateExercises(exercises)
    }

    private fun handleExerciseSelection(exercise: Exercise) {

        choose_exercise_list.visibility = View.GONE

        selected_exercise.visibility = View.VISIBLE
        create_workout_submit_button.visibility = View.VISIBLE
        input_reps_container.visibility = View.VISIBLE
        input_weight_container.visibility = View.VISIBLE
        workout_set_list.visibility = View.VISIBLE
        add_set_button.visibility = View.VISIBLE

        selectedExercise = exercise


        val exerciseItemBinding = DataBindingUtil.bind<ExerciseItemBinding>(selected_exercise)
        //Seems like an IDE bug: https://youtrack.jetbrains.com/issue/KT-12402
        @Suppress("MISSING_DEPENDENCY_CLASS")
        exerciseItemBinding.viewModel = ExerciseViewModel(exercise)
    }

    private fun handleExerciseDeselection() {
        choose_exercise_list.visibility = View.VISIBLE


        selected_exercise.visibility = View.GONE
        create_workout_submit_button.visibility = View.GONE
        input_reps_container.visibility = View.GONE
        input_weight_container.visibility = View.GONE
        workout_set_list.visibility = View.GONE
        add_set_button.visibility = View.GONE

        selectedExercise = null
    }
}
