package com.example.usecases.network

import com.example.entity.Post
import com.example.repository.network.PostRepositoryNetwork

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */
class PostUseCase(private val postRepositoryNetwork: PostRepositoryNetwork) {

    fun getPost(): List<Post>{
        return postRepositoryNetwork.getPosts()
    }

    fun getPostDetail(id: String): Post{
        return postRepositoryNetwork.getPostDetail(id = id)
    }
}