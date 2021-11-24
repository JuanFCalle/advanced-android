package com.juancalle.advancedandroid.navigation

import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import javax.inject.Inject

class DefaultScreenNavigator @Inject constructor() : ScreenNavigator {
    private var router: Router? = null
    private val controllerChangeListener =
        object : ControllerChangeHandler.ControllerChangeListener {
            override fun onChangeStarted(
                to: Controller?,
                from: Controller?,
                isPush: Boolean,
                container: ViewGroup,
                handler: ControllerChangeHandler
            ) {
                TODO("Not yet implemented")
            }

            override fun onChangeCompleted(
                to: Controller?,
                from: Controller?,
                isPush: Boolean,
                container: ViewGroup,
                handler: ControllerChangeHandler
            ) {
                TODO("Not yet implemented")
            }

        }

    override fun initWithRouter(router: Router, rootScreen: Controller) {
        this.router = router.apply {
            if (hasRootController().not()) setRoot(RouterTransaction.with(rootScreen))
            addChangeListener(controllerChangeListener)
        }
    }

    override fun pop(): Boolean = router?.handleBack() ?: false

    override fun clear() {
        router = null
    }
}