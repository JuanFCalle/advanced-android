package com.juancalle.advancedandroid.home

import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.juancalle.advancedandroid.common.BaseActivity
import com.juancalle.advancedandroid.databinding.ActivityMainBinding
import com.juancalle.advancedandroid.trendingrepositories.view.TrendingRepositoriesListScreen

class MainActivity : BaseActivity() {

    override val rootScreen: Controller
        get() = TrendingRepositoriesListScreen()

    override fun getRootViewGroup(): ViewGroup =
        ActivityMainBinding.inflate(layoutInflater).root

}