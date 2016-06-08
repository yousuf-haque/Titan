package com.yohaq.titan.injection.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by yousufhaque on 6/7/16.
 */
@Module
class ApplicationModule(val context: Context) {

    @Provides
    fun providesContext(): Context = context
}