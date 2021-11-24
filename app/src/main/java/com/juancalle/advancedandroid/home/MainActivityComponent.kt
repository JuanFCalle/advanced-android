package com.juancalle.advancedandroid.home

import com.juancalle.advancedandroid.navigation.ScreenNavigatorModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        ScreenNavigatorModule::class
    ]
)
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}