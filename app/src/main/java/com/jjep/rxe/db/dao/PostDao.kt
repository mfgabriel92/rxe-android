package com.jjep.rxe.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.jjep.rxe.db.entity.Post
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg posts: Post)

    @Query("SELECT * FROM posts ORDER BY createdAt DESC")
    fun fetchAll(): List<Post>
}