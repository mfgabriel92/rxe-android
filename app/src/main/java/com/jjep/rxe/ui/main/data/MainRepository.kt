package com.jjep.rxe.ui.main.data

import com.jjep.rxe.db.entity.Post
import com.jjep.rxe.ext.addTo
import com.jjep.rxe.network.Repository
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
) : Repository<Post> {
    override val outcome = PublishSubject.create<Response<List<Post>>>()

    override fun fetchAll() {
        Observable.fromCallable { local.fetchPosts() }
            .doOnNext {
                remote.fetchPosts().concatMap { posts ->
                    local.insert(*posts.toTypedArray())
                    Observable.just(posts)
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { outcome.success(it) },
                { error: Throwable -> outcome.failed(error) }
            ).addTo(compositeDisposable)
    }
}