package com.jjep.rxe.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.jjep.rxe.R
import com.jjep.rxe.db.entity.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_post.view.*

class MainActivityAdapter(private val picasso: Picasso) : RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder>() {
    private var posts = emptyList<Post>()
    var onPostClickListener: OnPostClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityViewHolder {
        return MainActivityViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        holder.bind(posts[position])

        holder.itemView.setOnClickListener { view ->
            with (view) { onPostClickListener?.onPostClick(posts[position]) }
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setData(posts: List<Post>?) {
        this.posts = posts ?: this.posts
        notifyDataSetChanged()
    }

    interface OnPostClickListener {
        fun onPostClick(post: Post)
    }

    inner class MainActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: Post) {
            with(post) {
                itemView.tv_post_title.text = title
                itemView.tv_post_created_at.text = TimeAgo.using(createdAt.time)
                itemView.tv_post_body.text = body
            }
        }
    }
}