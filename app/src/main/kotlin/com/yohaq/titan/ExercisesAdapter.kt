package com.yohaq.titan

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yohaq.titan.databinding.ExerciseItemBinding
import java.util.*

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExercisesAdapter : RecyclerView.Adapter<ExercisesAdapter.ExercisesViewHolder>() {
    lateinit var exercises: List<Exercise>

    init {

        exercises = ArrayList<Exercise>()
        for (name in arrayOf("push up", "sit up")) {
            (exercises as ArrayList<Exercise>).add(Exercise(name))
        }

    }

    class ExercisesViewHolder(val exerciseItemBinding: ExerciseItemBinding) : RecyclerView.ViewHolder(exerciseItemBinding.root)


    override fun getItemCount() = exercises.size


    override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
        holder.exerciseItemBinding.viewModel = ExerciseViewModel(exercises[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesViewHolder? {
        val exerciseItemBinding: ExerciseItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.exercise_item, parent, false)
        exerciseItemBinding.root.setOnClickListener ({
            view: View ->
            Toast.makeText(view.context, "click", Toast.LENGTH_LONG).show()
        })
        return ExercisesViewHolder(exerciseItemBinding)
    }

}