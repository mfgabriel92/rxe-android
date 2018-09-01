package com.jjep.rxe.ui.main.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.jjep.rxe.db.entity.Post
import com.jjep.rxe.network.Response
import com.jjep.rxe.network.toLiveData
import com.jjep.rxe.ui.main.MainDH
import com.jjep.rxe.ui.main.data.MainRepository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val repository: MainRepository, private val compositeDisposable: CompositeDisposable) : ViewModel() {
    val posts: LiveData<Response<List<Post>>> by lazy {
        repository.outcome.toLiveData(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        MainDH.destroyMainComponent()
    }

    fun fetchPosts() {
        if (posts.value == null) {
            repository.fetchAll()
        }
    }
}