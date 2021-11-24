package com.juancalle.advancedandroid.trendingrepositories.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.juancalle.advancedandroid.common.BaseScreen
import com.juancalle.advancedandroid.databinding.ScreenRepositoriesListBinding

class TrendingRepositoriesListScreen : BaseScreen<ScreenRepositoriesListBinding>() {

    override val inflateBinding: (LayoutInflater, ViewGroup?, Boolean) -> ScreenRepositoriesListBinding
        get() = ScreenRepositoriesListBinding::inflate
}