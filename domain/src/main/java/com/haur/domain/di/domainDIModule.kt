package com.haur.domain.di

import com.haur.domain.usecases.CheckPostAsReadUseCase
import com.haur.domain.usecases.DismissAllPostsUseCase
import com.haur.domain.usecases.DismissPostUseCase
import org.koin.dsl.module


val domainModule = module {
    factory { CheckPostAsReadUseCase(get()) }
    factory { DismissAllPostsUseCase() }
    factory { DismissPostUseCase(get()) }
}