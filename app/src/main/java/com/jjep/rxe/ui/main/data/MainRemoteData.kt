package com.jjep.rxe.ui.main.data

import com.jjep.rxe.network.RxeService

class MainRemoteData(private val service: RxeService) {
    fun fetchPosts() = service.fetchPosts()
}