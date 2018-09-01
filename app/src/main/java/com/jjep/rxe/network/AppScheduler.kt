package com.jjep.rxe.network

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppScheduler : Scheduler {
    override fun mainThread() = AndroidSchedulers.mainThread()!!

    override fun io() = Schedulers.io()
}