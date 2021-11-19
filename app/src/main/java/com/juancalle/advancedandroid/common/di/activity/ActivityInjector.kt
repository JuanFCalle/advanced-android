package com.juancalle.advancedandroid.common.di.activity

import android.app.Activity
import com.juancalle.advancedandroid.MainApplication
import com.juancalle.advancedandroid.common.BaseActivity
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Provider

class ActivityInjector @Inject constructor(
    private val activityComponentFactoryMap:
    Map<Class<out Activity>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Activity>>>
) {
    private val activityComponentMap: HashMap<String, AndroidInjector<Activity>> = hashMapOf()

    @Suppress("UNCHECKED_CAST")
    private fun injectActivity(activity: Activity) =
        if (activity is BaseActivity)
            activityComponentMap.getOrPut(activity.instanceId) {
                activityComponentFactoryMap.getValue(activity.javaClass).get().let {
                    it as AndroidInjector.Factory<Activity>
                }.create(activity)
            }.inject(activity)
        else
            throw IllegalArgumentException("Activity must extend BaseActivity")

    private fun clearActivity(activity: Activity) =
        if (activity is BaseActivity)
            activityComponentMap.remove(activity.instanceId)
        else
            throw IllegalArgumentException("Activity must extend BaseActivity")

    companion object {
        fun inject(activity: Activity) {
            activity.application.let {
                it as MainApplication
            }.activityInjector.injectActivity(activity)
        }

        fun clear(activity: Activity) {
            activity.application.let {
                it as MainApplication
            }.activityInjector.clearActivity(activity)
        }

    }
}