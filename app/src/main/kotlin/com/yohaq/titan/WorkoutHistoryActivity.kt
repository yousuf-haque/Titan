package com.yohaq.titan

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnMenuTabClickListener

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
                    R.id.history_nav_button -> Toast.makeText(activity, "history", Toast.LENGTH_LONG).show()
                    R.id.exercise_nav_button -> Toast.makeText(activity, "exercises", Toast.LENGTH_LONG).show()
                }
            }
        });


    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        bottomBar?.onSaveInstanceState(outState)
    }
}
