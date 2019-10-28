package com.example.testperuapps.application

import android.app.Application
import com.example.di.usescasesModule

import com.example.repository.network.di.networkModule
import com.example.repository.utils.BASE_URL
import com.example.testperuapps.BuildConfig
import com.example.testperuapps.data.PostRepository
import com.example.testperuapps.di.viewModelModules
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */
class PeruAppsApplication: Application() {

    var postRepository: PostRepository? = null
        private set

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@PeruAppsApplication)
            modules(arrayListOf(networkModule, usescasesModule, viewModelModules))
        }
        getKoin().setProperty(BASE_URL, BuildConfig.BASE_URL)

        postRepository = PostRepository(this)
    }
}