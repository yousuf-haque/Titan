package com.yohaq.titan.injection.modules

import dagger.Module
import dagger.Provides
import io.realm.Realm

/**
 * Created by yousufhaque on 6/7/16.
 */
@Module
class RealmModule {

    @Provides
    fun providesRealm() = Realm.getDefaultInstance()
}