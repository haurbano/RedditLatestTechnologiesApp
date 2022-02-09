package com.haur.data.di

import androidx.paging.PagingSource
import com.haur.data.services.PostPagingRemoteDataSource
import com.haur.data.services.TopPostRemoteService
import com.haur.domain.models.Post
import com.haur.domain.repositories.PostsRepository

class PagingSourceFactory(
    private val postRemoteService: TopPostRemoteService,
    private val postsRepository: PostsRepository
) {
    fun getPostsPagingSource(): PagingSource<String, Post> {
        return PostPagingRemoteDataSource(postRemoteService, postsRepository)
    }
}