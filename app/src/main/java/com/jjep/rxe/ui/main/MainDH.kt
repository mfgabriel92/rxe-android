package com.jjep.rxe.ui.main

import com.jjep.rxe.App
import com.jjep.rxe.ui.main.di.DaggerMainComponent
import com.jjep.rxe.ui.main.di.MainComponent
import javax.inject.Singleton

@Singleton
object MainDH {
    private var mainComponent: MainComponent? = null

    fun mainComponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = DaggerMainComponent.builder().appComponent(App.appComponent).build()
        }

        return mainComponent as MainComponent
    }

    fun destroyMainComponent() {
        mainComponent = null
    }
}