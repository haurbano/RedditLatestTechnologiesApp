package com.haur.domain.repositories

import com.haur.domain.commons.Resource
import com.haur.domain.models.Post

interface PostsRepository {
    suspend fun getTopPosts(): Resource<List<Post>>
    suspend fun checkPostAsRead(id: String): Resource<Boolean>
    suspend fun dismissPost(id: String): Resource<Boolean>
    suspend fun isPostDismissed(id: String): Resource<Boolean>
    suspend fun isPostAlreadyRead(id: String): Resource<Boolean>
}