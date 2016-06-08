package com.yohaq.titan

import android.app.Application
import com.yohaq.titan.injection.components.ApplicationComponent
import com.yohaq.titan.injection.components.DaggerApplicationComponent
import com.yohaq.titan.injection.modules.ApplicationModule
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class TitanApplication : Application() {
    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    @Inject
    lateinit var realmConfiguration: RealmConfiguration

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        appComponent.inject(this)
        Realm.deleteRealm(realmConfiguration)

        Realm.setDefaultConfiguration(realmConfiguration)
    }
}