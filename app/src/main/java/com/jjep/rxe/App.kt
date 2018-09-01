package com.jjep.rxe

import android.app.Application
import com.jjep.rxe.di.AppComponent
import com.jjep.rxe.di.AppModule
import com.jjep.rxe.di.DaggerAppComponent

open class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}