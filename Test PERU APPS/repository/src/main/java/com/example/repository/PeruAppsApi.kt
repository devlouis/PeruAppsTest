package com.example.repository

import com.example.repository.network.entity.response.PostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */
interface PeruAppsApi {

    @GET("posts")
    fun getPost() : Call<List<PostResponse>>

    @GET("posts/{id}")
    fun detailBenefit(@Path("id") idDiscount: String): Call<PostResponse>
}