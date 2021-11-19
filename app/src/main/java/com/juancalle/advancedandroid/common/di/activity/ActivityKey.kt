package com.juancalle.advancedandroid.common.di.activity

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ActivityKey(val value: KClass<out Activity>)
