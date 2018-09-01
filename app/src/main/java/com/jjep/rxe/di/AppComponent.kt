package com.jjep.rxe.di

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ImageModule::class])
interface AppComponent {
    fun context(): Context
    fun retrofit(): Retrofit
    fun picasso(): Picasso
}