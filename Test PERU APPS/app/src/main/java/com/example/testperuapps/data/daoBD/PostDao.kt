package com.example.testperuapps.data.daoBD

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.example.testperuapps.data.entity.PostEntity

/**
 * Created by Luis Lopez on 2019-10-27.
 * Solera Mobile
 * Peru, Lima.
 */

@Dao
interface PostDao {
    @Insert
    abstract fun insert(post: PostEntity)

    @Query("SELECT * FROM tb_post")
    abstract fun getAll(): List<PostEntity>

    @Update
    abstract fun update(note: PostEntity)
}