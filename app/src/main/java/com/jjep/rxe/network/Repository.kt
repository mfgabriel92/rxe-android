package com.jjep.rxe.network

import io.reactivex.subjects.PublishSubject

interface Repository<T> {
    val outcome: PublishSubject<Response<List<T>>>
    fun fetchAll()
}