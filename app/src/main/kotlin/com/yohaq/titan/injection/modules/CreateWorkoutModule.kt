package com.yohaq.titan.injection.modules

import dagger.Module
import dagger.Provides
import io.realm.Realm

/**
 * Created by yousufhaque on 6/8/16.
 */
@Module
class CreateWorkoutModule {
    @Provides
    fun provideRealm() = Realm.getDefaultInstance()
}