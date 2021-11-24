package com.juancalle.advancedandroid.navigation

import dagger.Binds
import dagger.Module

@Module
abstract class ScreenNavigatorModule {
    @Binds
    abstract fun provideDefaultScreenNavigator(
        defaultScreenNavigator: DefaultScreenNavigator
    ): ScreenNavigator
}