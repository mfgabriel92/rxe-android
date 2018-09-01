package com.jjep.rxe.ui.main.data

import com.jjep.rxe.db.RxeDatabase
import com.jjep.rxe.db.entity.Post

class MainLocalData(private val database: RxeDatabase) {
    fun fetchPosts() = database.postDao().fetchAll()

    fun insert(vararg posts: Post) = database.postDao().insert(*posts)
}