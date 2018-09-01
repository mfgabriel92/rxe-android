package com.jjep.rxe.ui.main.data

import com.jjep.rxe.network.RxeApi

class MainRemoteData(private val api: RxeApi) {
    fun fetchPosts() = api.fetchPosts()
}