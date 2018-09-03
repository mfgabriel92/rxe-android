package com.jjep.rxe.db.entity.post

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    @Embedded
    val title: Title,

    @SerializedName("excerpt")
    @Embedded
    val excerpt: Excerpt,

    @SerializedName("content")
    @Embedded
    val content: Content,

    @SerializedName("date")
    val date: String,

    @SerializedName("modified")
    val modified: String
)