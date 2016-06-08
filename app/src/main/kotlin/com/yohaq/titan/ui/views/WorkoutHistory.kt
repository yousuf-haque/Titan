package com.yohaq.titan.ui.views

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import com.yohaq.titan.data.models.Workout
import com.yohaq.titan.injection.components.DaggerWorkoutHistoryComponent
import com.yohaq.titan.presenters.CreateWorkoutPresenter
import com.yohaq.titan.presenters.WorkoutHistoryPresenter
import com.yohaq.titan.ui.adapters.WorkoutHistoryAdapter
import com.yohaq.titan.ui.views.interfaces.WorkoutHistoryView
import io.realm.Realm
import kotlinx.android.synthetic.main.view_workout_history.view.*
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class WorkoutHistory(context: Context?, attrs: AttributeSet?) : CoordinatorLayout(context, attrs), WorkoutHistoryView {
    @Inject
    lateinit var workoutHistoryAdapter: WorkoutHistoryAdapter

    @Inject
    lateinit var realm: Realm

    @Inject
    lateinit var presenter: WorkoutHistoryPresenter

    @Inject
    lateinit var presenter2: CreateWorkoutPresenter

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        DaggerWorkoutHistoryComponent.create().inject(this)
        workout_history_list.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        workout_history_list.adapter = workoutHistoryAdapter
        add_workout_button.setOnClickListener { handleCreateWorkoutButtonClick() }
        presenter.attachView(this)

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
    }

    private fun handleCreateWorkoutButtonClick() {
        presenter2.createWorkout(Date())
    }

    override fun showWorkouts(workouts: List<Workout>) {
        workoutHistoryAdapter.updateWorkouts(workouts)
    }
}