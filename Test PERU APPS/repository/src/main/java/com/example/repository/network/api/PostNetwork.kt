package com.example.repository.network.api

import com.example.entity.Post
import com.example.repository.PeruAppsApi
import com.example.repository.network.PostRepositoryNetwork
import com.example.repository.network.entity.response.PostResponse
import retrofit2.Call

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */
class PostNetwork (private val apiConfig: PeruAppsApi): PostRepositoryNetwork {

    override fun getPosts(): List<Post> {
        val callApplicationEntity: Call<List<PostResponse>> = apiConfig.getPost()
        val applicationEntity: List<PostResponse>? = callApplicationEntity.execute().body()
        return applicationEntity?.let { PostResponse.toPost(it) }!!

    }

    override fun getPostDetail(id: String): Post {
        val callApplicationEntity: Call<PostResponse> = apiConfig.detailBenefit(id)
        val applicationEntity: PostResponse? = callApplicationEntity.execute().body()
        return applicationEntity?.let { PostResponse.toPostDetail(it) }!!
    }
}