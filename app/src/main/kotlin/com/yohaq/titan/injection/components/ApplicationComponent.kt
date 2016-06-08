package com.yohaq.titan.injection.components

import android.content.Context
import com.yohaq.titan.injection.modules.ApplicationModule
import com.yohaq.titan.injection.scopes.ApplicationScope
import dagger.Component

/**
 * Created by yousufhaque on 6/7/16.
 */
@ApplicationScope
@Component (modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun getApplicationContext(): Context
}