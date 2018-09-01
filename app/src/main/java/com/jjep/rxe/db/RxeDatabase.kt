package com.jjep.rxe.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.jjep.rxe.db.dao.PostDao
import com.jjep.rxe.db.entity.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class RxeDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}