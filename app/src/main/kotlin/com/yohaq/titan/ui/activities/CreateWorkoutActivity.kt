package com.yohaq.titan.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yohaq.titan.R
import com.yohaq.titan.injection.components.DaggerCreateWorkoutComponent
import com.yohaq.titan.presenters.CreateWorkoutPresenter
import com.yohaq.titan.ui.views.interfaces.CreateWorkoutView
import kotlinx.android.synthetic.main.activity_create_workout.*
import java.util.*
import javax.inject.Inject

class CreateWorkoutActivity : AppCompatActivity(), CreateWorkoutView {

    companion object {

        fun createIntent(context: Context) =
                Intent(context, CreateWorkoutActivity::class.java)

    }

    @Inject
    lateinit var presenter: CreateWorkoutPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)
        DaggerCreateWorkoutComponent.create().inject(this)
        presenter.attachView(this)

        create_workout_submit_button.setOnClickListener { handleAddExerciseButtonClick() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    private fun handleAddExerciseButtonClick() {
        presenter.createWorkout(Date())
        finish()
    }
}
