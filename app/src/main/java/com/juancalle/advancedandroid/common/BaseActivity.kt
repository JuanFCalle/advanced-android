package com.juancalle.advancedandroid.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juancalle.advancedandroid.common.di.activity.ActivityInjector
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    lateinit var instanceId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        instanceId = savedInstanceState?.getString(INSTANCE_ID) ?: UUID.randomUUID().toString()
        ActivityInjector.inject(this)
        super.onCreate(savedInstanceState)
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