package com.jjep.rxe.ui.main.di

import com.jjep.rxe.network.RxeService
import com.jjep.rxe.db.RxeDatabase
import com.jjep.rxe.di.AppComponent
import com.jjep.rxe.ui.main.MainActivity
import dagger.Component

@PostScope
@Component(dependencies = [AppComponent::class], modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
    fun database(): RxeDatabase
    fun service(): RxeService
}