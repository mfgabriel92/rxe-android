package com.jjep.rxe.di

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {
    @Provides
    @Singleton
    fun providePicasso(context: Context): Picasso {
        return Picasso.Builder(context)
            .build()
    }
}