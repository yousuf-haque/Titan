package com.yohaq.titan.injection.modules

import android.content.Context
import com.yohaq.titan.injection.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by yousufhaque on 6/7/16.
 */
@Module
class ApplicationModule(val context: Context) {
    init {
        Realm.init(context)
    }

    @Provides
    fun providesContext(): Context = context

    @Provides
    @ApplicationScope
    fun provideRealmConfiguration() = RealmConfiguration.Builder()
            .name("titan.realmFactory")
            .build()
}