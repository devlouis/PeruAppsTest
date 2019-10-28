package com.example.testperuapps.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.entity.Post
import com.example.usecases.network.PostUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */
class PostViewModel(private val postUseCase: PostUseCase): ViewModel() {
    var postLiveData = MutableLiveData<MutableList<Post>>()
    var detailPostLiveData = MutableLiveData<Post>()

    fun getPostData(){
        CoroutineScope(Dispatchers.IO).launch {
            val listPost = postUseCase.getPost()
            Log.v(" listPost ", listPost.toString())
            postLiveData.postValue(listPost as MutableList<Post>)
        }
    }

    fun detailPost(id: String){
        CoroutineScope(Dispatchers.IO).launch {
            val detail = postUseCase.getPostDetail(id = id)
            Log.v(" detailPost ", detail.toString())
            detailPostLiveData.postValue(detail)
        }
    }
}