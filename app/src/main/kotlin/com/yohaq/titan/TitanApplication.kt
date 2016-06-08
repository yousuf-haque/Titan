package com.yohaq.titan

import android.app.Application
import com.yohaq.titan.injection.components.ApplicationComponent
import com.yohaq.titan.injection.components.DaggerApplicationComponent
import com.yohaq.titan.injection.modules.ApplicationModule

/**
 * Created by yousufhaque on 6/7/16.
 */
class TitanApplication : Application() {
    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }
}