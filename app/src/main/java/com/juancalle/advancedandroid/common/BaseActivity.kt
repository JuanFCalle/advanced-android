package com.juancalle.advancedandroid.common

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.juancalle.advancedandroid.common.di.activity.ActivityInjector
import com.juancalle.advancedandroid.navigation.ScreenNavigator
import java.util.*
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    abstract val rootScreen: Controller

    @Inject lateinit var screenNavigator: ScreenNavigator
    lateinit var instanceId: String
    private lateinit var router: Router
    private val screenContainer by lazy { getRootViewGroup() }

    abstract fun getRootViewGroup(): ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        instanceId = savedInstanceState?.getString(INSTANCE_ID) ?: UUID.randomUUID().toString()
        ActivityInjector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(screenContainer)
        router = Conductor.attachRouter(this, screenContainer, savedInstanceState).apply {
            screenNavigator.initWithRouter(this, rootScreen)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(INSTANCE_ID, instanceId)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) ActivityInjector.clear(this)
    }

    companion object {
        const val INSTANCE_ID = "instance_id"
    }
}