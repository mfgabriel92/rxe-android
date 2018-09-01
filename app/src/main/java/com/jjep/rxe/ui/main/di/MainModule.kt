package com.jjep.rxe.ui.main.di

import android.arch.persistence.room.Room
import android.content.Context
import com.jjep.rxe.network.RxeApi
import com.jjep.rxe.db.RxeDatabase
import com.jjep.rxe.ui.main.MainActivityAdapter
import com.jjep.rxe.ui.main.data.MainLocalData
import com.jjep.rxe.ui.main.data.MainRemoteData
import com.jjep.rxe.ui.main.data.MainRepository
import com.jjep.rxe.ui.main.viewmodel.MainViewModelFactory
import com.jjep.rxe.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@Module
class MainModule {
    @Provides
    @PostScope
    fun provideAdapter() = MainActivityAdapter()

    @Provides
    @PostScope
    fun provideViewModelFactory(repository: MainRepository, compositeDisposable: CompositeDisposable) = MainViewModelFactory(repository, compositeDisposable)

    @Provides
    @PostScope
    fun provideRepository(remote: MainRemoteData, local: MainLocalData, compositeDisposable: CompositeDisposable) = MainRepository(remote, local, compositeDisposable)

    @Provides
    @PostScope
    fun provideRemoteData(api: RxeApi) = MainRemoteData(api)

    @Provides
    @PostScope
    fun provideLocalData(database: RxeDatabase) = MainLocalData(database)

    @Provides
    @PostScope
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @PostScope
    fun provideDatabase(context: Context): RxeDatabase = Room.databaseBuilder(context, RxeDatabase::class.java, DATABASE_NAME).build()

    @Provides
    @PostScope
    fun provideApi(retrofit: Retrofit): RxeApi = retrofit.create(RxeApi::class.java)
}