package com.example.testperuapps.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.entity.Post
import java.io.Serializable

/**
 * Created by Luis Lopez on 2019-10-27.
 * Solera Mobile
 * Peru, Lima.
 */
@Entity(tableName = "tb_post")
class PostEntity: Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idRoom")
    var idRoom: Long = 0

    var id: Int? = 0
    var userId: Int? = 0
    var title: String? = ""
    var body: String? = ""
    var commentary: String? = ""

    companion object{
        fun toPost(entitys: List<PostEntity>): List<Post>{
            val postModels = ArrayList<Post>()
            if (entitys != null){
                for (entity in entitys){
                    postModels.add(Post(
                        entity.idRoom ?: 0,
                        entity.userId ?: 0,
                        entity.id ?: 0,
                        entity.title ?: "",
                        entity. body?: "",
                        entity.commentary ?: ""))
                }
            }
            return postModels
        }
    }
}