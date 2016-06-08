package com.yohaq.titan.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnMenuTabClickListener
import com.yohaq.titan.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_exercises.view.*
import kotlinx.android.synthetic.main.view_history.view.*

class MainActivity : AppCompatActivity() {

    private var bottomBar: BottomBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomBar(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        bottomBar?.onSaveInstanceState(outState)
    }

    private fun initBottomBar( savedInstanceState: Bundle?) {
        bottomBar = BottomBar.attach(this, savedInstanceState)
        bottomBar!!.setItems(R.menu.bottom_bar_menu);
        bottomBar!!.setOnMenuTabClickListener(object : OnMenuTabClickListener {
            override fun onMenuTabReSelected(menuItemId: Int) {
                handleTabNavigation(menuItemId)
            }

            override fun onMenuTabSelected(menuItemId: Int) {
                handleTabNavigation(menuItemId)
            }
        });
    }

    private fun handleTabNavigation(menuItemId: Int) {
        when (menuItemId) {
            R.id.history_nav_button -> {
                content.history_list_container.visibility = View.VISIBLE
                content.exercise_list_container.visibility = View.GONE

            }
            R.id.exercise_nav_button -> {
                content.exercise_list_container.visibility = View.VISIBLE
                content.history_list_container.visibility = View.GONE
            }
        }
    }


}
