package com.example.testperuapps.data

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.testperuapps.data.daoBD.PostDao
import com.example.testperuapps.data.entity.PostEntity

/**
 * Created by Luis Lopez on 2019-10-27.
 * Solera Mobile
 * Peru, Lima.
 */

@Database(entities = [PostEntity::class], version = 4)
abstract class PostDataBase: RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        private var INSTANCE: PostDataBase? = null
        fun getInstance(context: Context): PostDataBase? {
            if (INSTANCE == null) {
                synchronized(PostDataBase::class.java) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            PostDataBase::class.java, "BDRoomPost.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build()

                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }

        private val sRoomDatabaseCallback = object : Callback() {

            override fun onOpen(@NonNull db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                //clearNotes(INSTANCE);
            }

        }
    }
}