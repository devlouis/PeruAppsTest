package com.example.testperuapps.ui.main

import android.app.Application
import android.os.Handler
import android.view.View
import android.widget.TextView
import com.example.entity.Post
import com.example.testperuapps.data.PostRepository
import com.example.testperuapps.data.entity.PostEntity


/**
 * Created by Luis Lopez on 2019-10-27.
 * Solera Mobile
 * Peru, Lima.
 */
class DBRoomQuery(val vLoading: View, val rlaDialog: View) {

    fun saveRoom(post : Post){
        vLoading.visibility = View.VISIBLE
        var data = PostEntity()
        data.title = post.title
        data.body = post.body
        data.id = post.id
        data.userId = post.userId
        PostRepository(Application()).add(data)
        Handler().postDelayed({
            vLoading.visibility = View.GONE
            rlaDialog.visibility = View.GONE
        },1500)
    }

    fun updateRoom(post : Post, eteComentario: TextView){
        vLoading.visibility = View.VISIBLE
        var data = PostEntity()
        data.idRoom = post.idRoom
        data.title = post.title
        data.body = post.body
        data.id = post.id
        data.userId = post.userId
        data.commentary = eteComentario.text.toString()
        PostRepository(Application()).update(data)
        Handler().postDelayed({
            vLoading.visibility = View.GONE
            rlaDialog.visibility = View.GONE

        },1500)
    }
}