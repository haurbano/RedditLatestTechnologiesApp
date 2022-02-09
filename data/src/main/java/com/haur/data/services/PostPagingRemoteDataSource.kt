package com.haur.data.services

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.haur.data.responses.toPostList
import com.haur.domain.models.Post
import com.haur.domain.repositories.PostsRepository

class PostPagingRemoteDataSource(
    private val topPostRemoteService: TopPostRemoteService,
    private val repository: PostsRepository
): PagingSource<String, Post>() {
    override fun getRefreshKey(state: PagingState<String, Post>): String? {
        return state.anchorPosition?.let {
            state.closestItemToPosition(it)?.after
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Post> {
        val response = topPostRemoteService.getPosts(afterKey = params.key ?: "")
        val posts = response.toPostList()
            .filter { !repository.isPostDismissed(it.id) }
            .filter { !repository.isPostAlreadyRead(it.id) }

        return LoadResult.Page(
            prevKey = params.key,
            nextKey = response.data.after,
            data = posts
        )
    }

    override val keyReuseSupported = true
}