package com.jjep.rxe.ui.main.data

import android.util.Log
import com.jjep.rxe.db.entity.post.Post
import com.jjep.rxe.ext.addTo
import com.jjep.rxe.network.Response
import com.jjep.rxe.network.failed
import com.jjep.rxe.network.success
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class MainRepository(
    private val remote: MainRemoteData,
    private val local: MainLocalData,
    private val compositeDisposable: CompositeDisposable
) {
    val outcome = PublishSubject.create<Response<List<Post>>>()

    fun fetchPosts() {
        remote.fetchPosts()
            .doOnNext { posts -> local.insert(posts) }
            .onErrorResumeNext { e: Throwable -> Log.d("MainRepository", e.message); Observable.fromCallable { local.fetchPosts() } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { outcome.success(it) },
                { error: Throwable -> outcome.failed(error) }
            ).addTo(compositeDisposable)
    }
}