package com.example.ktorphilipplackner.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ktorphilipplackner.data.remote.PostsService
import com.example.ktorphilipplackner.data.remote.dto.PostResponse

class MainViewModel : ViewModel() {

    private val client = PostsService.create()

    private val _postList: MutableLiveData<List<PostResponse>> = MutableLiveData()
    val postList: LiveData<List<PostResponse>> = _postList

    suspend fun getPosts() {
        _postList.value = client.getPosts()
    }

}