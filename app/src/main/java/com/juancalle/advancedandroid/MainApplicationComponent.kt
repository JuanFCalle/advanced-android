package com.juancalle.advancedandroid

import com.juancalle.advancedandroid.common.di.ActivityComponentFactoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityComponentFactoryModule::class
    ]
)
interface MainApplicationComponent {
    fun inject(mainApplication: MainApplication)
}