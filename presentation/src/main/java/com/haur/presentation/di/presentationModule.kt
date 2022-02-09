package com.haur.presentation.di

import com.haur.presentation.topposts.TopPostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { TopPostsViewModel(get(), get()) }
}