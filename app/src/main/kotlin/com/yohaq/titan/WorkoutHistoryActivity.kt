package com.yohaq.titan

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnMenuTabClickListener
import kotlinx.android.synthetic.main.activity_workout_history.*
import kotlinx.android.synthetic.main.view_exercises.view.*
import kotlinx.android.synthetic.main.view_history.view.*

class WorkoutHistoryActivity : AppCompatActivity() {

    private var bottomBar: BottomBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = this;
        setContentView(R.layout.activity_workout_history)

        bottomBar = BottomBar.attach(this, savedInstanceState)

        bottomBar!!.setItems(R.menu.bottom_bar_menu);
        bottomBar!!.setOnMenuTabClickListener(object : OnMenuTabClickListener {
            override fun onMenuTabReSelected(menuItemId: Int) {
                handleExerciseNavigation(menuItemId)
            }

            override fun onMenuTabSelected(menuItemId: Int) {
                handleExerciseNavigation(menuItemId)
            }

            private fun handleExerciseNavigation(menuItemId: Int) {
                when (menuItemId) {
                    R.id.history_nav_button -> {
                        activity.content.history_list.visibility = View.VISIBLE
                        activity.content.exercise_list.visibility = View.GONE

                    }
                    R.id.exercise_nav_button -> {
                        activity.content.exercise_list.visibility = View.VISIBLE
                        activity.content.history_list.visibility = View.GONE
                    }
                }
            }
        });


    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        bottomBar?.onSaveInstanceState(outState)
    }
}
