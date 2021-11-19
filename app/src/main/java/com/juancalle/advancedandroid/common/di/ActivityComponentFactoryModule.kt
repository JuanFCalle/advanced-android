package com.juancalle.advancedandroid.common.di

import android.app.Activity
import com.juancalle.advancedandroid.common.di.activity.ActivityKey
import com.juancalle.advancedandroid.home.MainActivity
import com.juancalle.advancedandroid.home.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        MainActivityComponent::class
    ]
)
abstract class ActivityComponentFactoryModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun provideMainActivityComponentFactory(
        mainActivityComponentFactory: MainActivityComponent.Factory
    ): AndroidInjector.Factory<out Activity>
}