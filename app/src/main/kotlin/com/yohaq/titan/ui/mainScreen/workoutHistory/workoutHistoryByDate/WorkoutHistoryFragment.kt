package com.yohaq.titan.ui.mainScreen.workoutHistory.workoutHistoryByDate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yohaq.titan.R
import com.yohaq.titan.data.models.Workout
import com.yohaq.titan.ui.createWorkoutScreen.CreateWorkoutActivity
import com.yohaq.titan.ui.mainScreen.workoutHistory.DaggerWorkoutHistoryComponent
import com.yohaq.titan.ui.mainScreen.workoutHistory.WorkoutHistoryPresenter
import com.yohaq.titan.ui.mainScreen.workoutHistory.adapters.WorkoutHistoryAdapter
import com.yohaq.titan.ui.mainScreen.workoutHistory.workoutHistoryByDate.WorkoutHistoryByDateView
import kotlinx.android.synthetic.main.daily_workout_fragment.*
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 7/16/16.
 */
class WorkoutHistoryFragment : Fragment(), WorkoutHistoryByDateView {

    companion object {
        const val EXTRA_WORKOUT_DATE = "workout date"

        fun newInstance(date: Date): WorkoutHistoryFragment =
                WorkoutHistoryFragment().apply {
                    arguments = Bundle().apply { putLong(EXTRA_WORKOUT_DATE, date.time) }
                }


    }


    @Inject
    lateinit var workoutHistoryAdapter: WorkoutHistoryAdapter


    @Inject
    lateinit var presenter: WorkoutHistoryPresenter


    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    private fun handleCreateWorkoutButtonClick() {
        context.startActivity(CreateWorkoutActivity.createIntent(context))
    }

    override fun showWorkouts(workouts: List<Workout>) {
        workoutHistoryAdapter.updateWorkouts(workouts)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.daily_workout_fragment, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerWorkoutHistoryComponent.create().inject(this)
        workout_history_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        workout_history_list.adapter = workoutHistoryAdapter
        add_workout_button.setOnClickListener { handleCreateWorkoutButtonClick() }
        presenter.attachView(this)

    }

    override fun showDate(date: Date) {

    }


}