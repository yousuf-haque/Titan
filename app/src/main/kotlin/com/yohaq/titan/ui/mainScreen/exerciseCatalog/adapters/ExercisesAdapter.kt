package com.yohaq.titan.ui.mainScreen.exerciseCatalog.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yohaq.titan.R
import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.databinding.ExerciseItemBinding
import rx.Observable
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExercisesAdapter
@Inject
constructor()
: RecyclerView.Adapter<ExercisesAdapter.ExercisesViewHolder>() {


    class ExercisesViewHolder(val exerciseItemBinding: ExerciseItemBinding) : RecyclerView.ViewHolder(exerciseItemBinding.root)


    private var exercises: List<Exercise>

    init {
        exercises = ArrayList<Exercise>()
    }

    var onExerciseClick: ((Exercise) -> Unit)? = null


    override fun getItemCount() = exercises.size


     val bindObservable = { exercisesObservable: Observable<List<Exercise>> ->
        exercisesObservable.doOnNext { exercises: List<Exercise> ->
            this.exercises = exercises

            notifyDataSetChanged()
        }
    }



    override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
        //Seems like an IDE bug: https://youtrack.jetbrains.com/issue/KT-12402
        @Suppress("MISSING_DEPENDENCY_CLASS")
        holder.exerciseItemBinding.viewModel = ExerciseViewModel(exercises[position])

        onExerciseClick?.let {
            holder.exerciseItemBinding.root.setOnClickListener {
                onExerciseClick!!.invoke(exercises[position])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesViewHolder? {
        val exerciseItemBinding: ExerciseItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.exercise_item, parent, false)
        return ExercisesViewHolder(exerciseItemBinding)
    }


}

