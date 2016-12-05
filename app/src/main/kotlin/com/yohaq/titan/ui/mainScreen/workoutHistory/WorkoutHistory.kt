package com.yohaq.titan.ui.mainScreen.workoutHistory

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import com.yohaq.titan.data.models.Workout
import com.yohaq.titan.ui.createWorkoutScreen.CreateWorkoutActivity
import com.yohaq.titan.ui.mainScreen.workoutHistory.adapters.WorkoutHistoryAdapter
import kotlinx.android.synthetic.main.view_workout_history.view.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class WorkoutHistory(context: Context?, attrs: AttributeSet?) : CoordinatorLayout(context, attrs), WorkoutHistoryView {
    @Inject
    lateinit var workoutHistoryAdapter: WorkoutHistoryAdapter


    @Inject
    lateinit var presenter: WorkoutHistoryPresenter


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        DaggerWorkoutHistoryComponent.create().inject(this)
        workout_history_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        workout_history_list.adapter = workoutHistoryAdapter
        add_workout_button.setOnClickListener { handleCreateWorkoutButtonClick() }
        presenter.attachView(this)

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
    }

    private fun handleCreateWorkoutButtonClick() {
        context.startActivity(CreateWorkoutActivity.createIntent(context))
    }

    override fun showWorkouts(workouts: List<Workout>) {
        workoutHistoryAdapter.updateWorkouts(workouts)
    }
}