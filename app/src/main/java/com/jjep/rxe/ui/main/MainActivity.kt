package com.jjep.rxe.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.jjep.rxe.R
import com.jjep.rxe.db.entity.Post
import com.jjep.rxe.network.Response
import com.jjep.rxe.ui.main.viewmodel.MainViewModel
import com.jjep.rxe.ui.main.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityAdapter.OnPostClickListener {
    @Inject
    lateinit var adapter: MainActivityAdapter
    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private val component by lazy { MainDH.mainComponent() }
    private val viewModel: MainViewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java) }
    private val context: Context by lazy { this }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)

        rv_posts.adapter = adapter

        listen()
    }

    override fun onPostClick(post: Post) {
        Toast.makeText(context, post.title, Toast.LENGTH_SHORT).show()
    }

    private fun listen() {
        viewModel.fetchPosts()
        viewModel.posts.observe(this, Observer<Response<List<Post>>> { result ->
            when (result) {
                is Response.Success -> { adapter.setData(result.data) }
                is Response.Failure -> { Toast.makeText(context, "Error: ${result.e}", Toast.LENGTH_SHORT).show() }
            }
        })
    }
}