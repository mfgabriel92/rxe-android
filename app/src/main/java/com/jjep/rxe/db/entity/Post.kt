package com.jjep.rxe.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,

    @SerializedName("image")
    val image: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String,

    @SerializedName("created_at")
    val createdAt: Date,

    @SerializedName("updated_at")
    val updatedAt: Date
)