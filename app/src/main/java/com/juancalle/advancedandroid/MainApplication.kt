package com.juancalle.advancedandroid

import android.app.Application
import com.juancalle.advancedandroid.common.di.activity.ActivityInjector
import javax.inject.Inject

class MainApplication : Application() {

    @Inject lateinit var activityInjector: ActivityInjector

    override fun onCreate() {
        super.onCreate()
        DaggerMainApplicationComponent.create().also { it.inject(this) }
    }

}