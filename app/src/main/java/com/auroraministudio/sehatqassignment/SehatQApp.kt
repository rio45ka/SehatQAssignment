package com.auroraministudio.sehatqassignment

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@HiltAndroidApp
class SehatQApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}