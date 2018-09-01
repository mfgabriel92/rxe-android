package com.jjep.rxe.ui.main.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jjep.rxe.ui.main.data.MainRepository
import io.reactivex.disposables.CompositeDisposable

class MainViewModelFactory(private val repository: MainRepository, private val compositeDisposable: CompositeDisposable) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository, compositeDisposable) as T
    }
}