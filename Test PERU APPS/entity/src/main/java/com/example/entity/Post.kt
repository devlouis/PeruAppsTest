package com.example.entity

import java.io.Serializable

/**
 * Created by Luis Lopez on 2019-10-27.
 * Solera Mobile
 * Peru, Lima.
 */
data class Post (
    var idRoom: Long = 0,
    val userId: Int? = 0,
    val id: Int? = 0,
    val title: String? = "",
    val body: String? = "",
    val commentary: String? = "") : Serializable