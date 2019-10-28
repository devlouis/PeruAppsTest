package com.example.repository.network.entity.response

import com.example.entity.Post
import java.io.Serializable

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 *
 */
data class PostResponse(
    val userId: Int? = 0,
    val id: Int? = 0,
    val title: String? = "",
    val body: String? = "") : Serializable{

    companion object{
        fun toPost(response: List<PostResponse>): List<Post> {
            var postModels = ArrayList<Post>()
            for (item in response){
                postModels.add(Post(
                    userId  = item.userId ?: 0,
                    id      = item.id ?: 0,
                    title   = item.title ?: "",
                    body    = item.body ?: ""
                ))
            }
            return postModels
        }

        fun toPostDetail(response: PostResponse): Post{
            return Post(
                userId  = response.userId ?: 0,
                id      = response.id ?: 0,
                title   = response.title ?: "",
                body    = response.body ?: ""
            )
        }
    }
}