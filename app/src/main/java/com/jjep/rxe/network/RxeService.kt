package com.jjep.rxe.network

import com.jjep.rxe.db.entity.post.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface RxeService {
    @GET("posts/")
    fun fetchPosts(): Observable<List<Post>>
}