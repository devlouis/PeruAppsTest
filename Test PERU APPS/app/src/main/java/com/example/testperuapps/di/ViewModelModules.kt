package com.example.testperuapps.di

import com.example.testperuapps.ui.main.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */

val viewModelModules = module {
    viewModel { PostViewModel(get()) }

}