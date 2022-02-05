package com.haur.domain.usecases

import com.haur.domain.commons.Result
import com.haur.domain.models.Post
import com.haur.domain.repositories.PostsRepository

class GetTopPostUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(): Result<List<Post>> {
        return postsRepository.getTopPosts()
    }
}