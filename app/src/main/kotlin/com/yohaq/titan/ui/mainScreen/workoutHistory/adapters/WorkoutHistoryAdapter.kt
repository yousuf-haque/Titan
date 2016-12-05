package com.yohaq.titan.ui.mainScreen.workoutHistory.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yohaq.titan.R
import com.yohaq.titan.data.models.Workout
import com.yohaq.titan.databinding.WorkoutItemBinding
import rx.Observable
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class WorkoutHistoryAdapter
@Inject
constructor()
    : RecyclerView.Adapter<WorkoutHistoryAdapter.WorkoutsViewHolder>() {

    class WorkoutsViewHolder(val workoutItemBinding: WorkoutItemBinding) : RecyclerView.ViewHolder(workoutItemBinding.root)

    private var workouts: List<Workout>

    init {
        workouts = mutableListOf()
    }

    val bindObservable = { workoutsObservable: Observable<List<Workout>> ->
        workoutsObservable.doOnNext { workouts: List<Workout> ->
            this.workouts = workouts
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = workouts.size


    override fun onBindViewHolder(holder: WorkoutsViewHolder, position: Int) {
        //Seems like an IDE bug: https://youtrack.jetbrains.com/issue/KT-12402
        @Suppress("MISSING_DEPENDENCY_CLASS")
        holder.workoutItemBinding.viewModel = WorkoutViewModel(workouts[position])


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutsViewHolder? {
        val workoutItemBinding: WorkoutItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.workout_item, parent, false)
        return WorkoutsViewHolder(workoutItemBinding)
    }

}