package com.jjep.rxe.network

import com.jjep.rxe.db.entity.Post
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface RxeApi {
    @GET("/posts")
    fun fetchPosts(): Observable<List<Post>>
}