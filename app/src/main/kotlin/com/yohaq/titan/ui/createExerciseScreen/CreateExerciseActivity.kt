package com.yohaq.titan.ui.createExerciseScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yohaq.titan.R
import kotlinx.android.synthetic.main.activity_create_exercise.*
import javax.inject.Inject


class CreateExerciseActivity : AppCompatActivity() {

    companion object {

        fun createIntent(context: Context) =
                Intent(context, CreateExerciseActivity::class.java)

    }

    @Inject
    lateinit var viewModel: CreateExerciseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_exercise)

        DaggerCreateExerciseComponent.create().inject(this)

        create_exercise_submit_button.setOnClickListener { handleSubmit() }
    }

    private fun handleSubmit() {
        viewModel.createExercise(exercise_name_input.text.toString())
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
