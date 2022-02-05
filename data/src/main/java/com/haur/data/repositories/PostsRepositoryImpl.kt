package com.haur.data.repositories

import com.haur.data.responses.toPostList
import com.haur.data.services.PostLocalService
import com.haur.data.services.TopPostRemoteService
import com.haur.domain.commons.Result
import com.haur.domain.commons.ResourceError
import com.haur.domain.models.Post
import com.haur.domain.repositories.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class PostsRepositoryImpl(
    private val postRemoteService: TopPostRemoteService,
    private val postLocalService: PostLocalService
): PostsRepository {
    override suspend fun getTopPosts(): Result<List<Post>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val posts = postRemoteService.getPosts().toPostList()
            Result.Success(posts)
        } catch (e: Exception) {
            Result.Error<Nothing>(ResourceError.NetworkError)
        }
    }

    override suspend fun checkPostAsRead(id: String): Result<Boolean> = withContext(Dispatchers.IO) {
        postLocalService.checkPostAsRead(id)
    }

    override suspend fun dismissPost(id: String): Result<Boolean> = withContext(Dispatchers.IO) {
        postLocalService.dismissPost(id)
    }

    override suspend fun isPostDismissed(id: String): Result<Boolean> = withContext(Dispatchers.IO) {
        postLocalService.isPostDismissed(id)
    }

    override suspend fun isPostAlreadyRead(id: String): Result<Boolean> = withContext(Dispatchers.IO) {
        postLocalService.isPostAlreadyRead(id)
    }
}