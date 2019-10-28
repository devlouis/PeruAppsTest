package com.example.testperuapps.data

import android.app.Application
import android.os.AsyncTask
import com.example.entity.Post
import com.example.testperuapps.data.daoBD.PostDao
import com.example.testperuapps.data.entity.PostEntity

/**
 * Created by Luis Lopez on 2019-10-27.
 * Solera Mobile
 * Peru, Lima.
 */
class PostRepository(application: Application) {
    private var postDao: PostDao? = null

    init {
        var db = PostDataBase.getInstance(application)
        postDao = db!!.postDao()
    }


    fun add(entity: PostEntity) {
        //noteDao.insert(noteEntity);
        postDao?.let { InsertAsyncTask(it).execute(entity) }
    }

    fun getAllNotes(populateCallback: PopulateCallback) {
        postDao?.let { PopulateAsyncTask(it, populateCallback).execute() }
    }

    fun update(postEntity: PostEntity) {
        //noteDao.update(noteEntity);
        postDao?.let { UpdateAsyncTask(it).execute(postEntity) }
    }


    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: PostDao) :
        AsyncTask<PostEntity, Void, Void>() {

        override fun doInBackground(vararg params: PostEntity): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

    private class PopulateAsyncTask internal constructor(
        private val mAsyncTaskDao: PostDao,
        private val populateCallback: PopulateCallback?
    ) : AsyncTask<Void, Void, List<PostEntity>>() {

        override fun doInBackground(vararg voids: Void): List<PostEntity> {
            return mAsyncTaskDao.getAll()
        }

        override fun onPostExecute(noteEntities: List<PostEntity>) {
            super.onPostExecute(noteEntities)
            populateCallback?.onSuccess(noteEntities)

        }
    }

    private class UpdateAsyncTask internal constructor(private val mAsyncTaskDao: PostDao) :
        AsyncTask<PostEntity, Void, Void>() {

        override fun doInBackground(vararg params: PostEntity): Void? {
            mAsyncTaskDao.update(params[0])
            return null
        }
    }

    interface PopulateCallback {
        fun onSuccess(postEntityList: List<PostEntity>)
        fun onFailure(e: Exception)
    }

}