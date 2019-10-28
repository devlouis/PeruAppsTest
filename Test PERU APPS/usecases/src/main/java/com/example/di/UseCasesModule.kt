package com.example.di

import com.example.usecases.network.PostUseCase
import org.koin.dsl.module

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */

val usescasesModule = module {
    single { PostUseCase(get()) }
}