package com.yohaq.titan.ui.mainScreen.workoutHistory

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import com.yohaq.titan.databinding.ViewWorkoutHistoryBinding
import com.yohaq.titan.ui.createWorkoutScreen.CreateWorkoutActivity
import com.yohaq.titan.ui.mainScreen.workoutHistory.adapters.WorkoutHistoryAdapter
import kotlinx.android.synthetic.main.view_workout_history.view.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class WorkoutHistory(context: Context?, attrs: AttributeSet?) : CoordinatorLayout(context, attrs) {
    @Inject
    lateinit var workoutHistoryAdapter: WorkoutHistoryAdapter


    @Inject
    lateinit var viewModel: WorkoutHistoryViewModel


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        DaggerWorkoutHistoryComponent.create().inject(this)
        val binding = ViewWorkoutHistoryBinding.bind(this)

        binding.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.adapter = workoutHistoryAdapter
        viewModel.allWorkoutsObservable.compose(workoutHistoryAdapter.bindObservable).bindToLifecycle(this).subscribe()


        add_workout_button.setOnClickListener { handleCreateWorkoutButtonClick() }

    }


    private fun handleCreateWorkoutButtonClick() {
        context.startActivity(CreateWorkoutActivity.createIntent(context))
    }


}