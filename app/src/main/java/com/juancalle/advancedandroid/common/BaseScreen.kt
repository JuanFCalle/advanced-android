package com.juancalle.advancedandroid.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.bluelinelabs.conductor.Controller

abstract class BaseScreen<T : ViewBinding> : Controller() {

    abstract val inflateBinding: (LayoutInflater, ViewGroup?, Boolean) -> T
    val binding get() = _binding!!
    private var _binding: T? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        _binding = inflateBinding(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        _binding = null
    }
}