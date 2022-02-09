package com.haur.data.di

import androidx.paging.PagingSource
import com.haur.data.services.PostPagingRemoteDataSource
import com.haur.data.services.TopPostRemoteService
import com.haur.domain.models.Post

class PagingSourceFactory(
    private val postRemoteService: TopPostRemoteService
) {
    fun getPostsPagingSource(): PagingSource<String, Post> {
        return PostPagingRemoteDataSource(postRemoteService)
    }
}