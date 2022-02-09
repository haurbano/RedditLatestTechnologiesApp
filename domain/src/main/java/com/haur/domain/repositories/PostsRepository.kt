package com.haur.domain.repositories

import com.haur.domain.commons.Result
import com.haur.domain.models.Post

interface PostsRepository {
    suspend fun checkPostAsRead(id: String): Result<Boolean>
    suspend fun dismissPost(id: String): Result<Boolean>
    suspend fun isPostDismissed(id: String): Boolean
    suspend fun isPostAlreadyRead(id: String): Boolean
}