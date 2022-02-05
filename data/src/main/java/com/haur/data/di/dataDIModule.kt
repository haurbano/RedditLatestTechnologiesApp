package com.haur.data.di

import com.haur.data.repositories.PostsRepositoryImpl
import com.haur.data.retrofit.RetrofitClient
import com.haur.data.services.PostLocalService
import com.haur.data.services.TopPostRemoteService
import com.haur.data.services.impl.PostLocalServiceImpl
import com.haur.domain.repositories.PostsRepository
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitClient }
    single { get<RetrofitClient>().create(TopPostRemoteService::class.java) }
    single <PostLocalService>{ PostLocalServiceImpl(get()) }
    factory<PostsRepository> { PostsRepositoryImpl(get(), get()) }
}