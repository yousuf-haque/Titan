package com.yohaq.titan.injection.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.RealmConfiguration

/**
 * Created by yousufhaque on 6/7/16.
 */
@Module
class RealmModule {
    @Provides
    fun provideRealmConfiguration(context: Context) = RealmConfiguration.Builder(context)
            .name("titan.realm")
            .build()
}