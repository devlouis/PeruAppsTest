package com.example.repository.network

import com.example.entity.Post

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */
interface PostRepositoryNetwork {
    @Throws(Exception::class)
    fun getPosts(): List<Post>

    @Throws(Exception::class)
    fun getPostDetail(id: String): Post
}