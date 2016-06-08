package com.yohaq.titan.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnMenuTabClickListener
import com.yohaq.titan.R
import com.yohaq.titan.injection.components.DaggerMainActivityComponent
import com.yohaq.titan.ui.adapters.ExercisesAdapter
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_exercises.*
import kotlinx.android.synthetic.main.view_exercises.view.*
import kotlinx.android.synthetic.main.view_history.view.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var bottomBar: BottomBar? = null

    @Inject
    lateinit var exerciseAdapter: ExercisesAdapter

    @Inject
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = this;
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.create().inject(this)

        initExerciseList()
        initBottomBar(activity, savedInstanceState)


    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        bottomBar?.onSaveInstanceState(outState)
    }

    private fun initBottomBar(activity: MainActivity, savedInstanceState: Bundle?) {
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
                        activity.content.history_list_container.visibility = View.VISIBLE
                        activity.content.exercise_list_container.visibility = View.GONE

                    }
                    R.id.exercise_nav_button -> {
                        activity.content.exercise_list_container.visibility = View.VISIBLE
                        activity.content.history_list_container.visibility = View.GONE
                    }
                }
            }
        });
    }

    private fun initExerciseList() {
        exercise_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        exercise_list.adapter = exerciseAdapter
        add_exercise_button.setOnClickListener { exerciseAdapter.presenter.createExercise() }

    }
}
