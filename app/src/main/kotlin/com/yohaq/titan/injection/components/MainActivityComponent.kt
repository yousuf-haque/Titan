package com.yohaq.titan.injection.components

import com.yohaq.titan.ui.activities.MainActivity
import dagger.Component

/**
 * Created by yousufhaque on 6/7/16.
 */
@Component
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}