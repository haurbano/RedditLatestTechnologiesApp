package com.haur.domain.usecases

import com.haur.domain.commons.Resource
import com.haur.domain.models.Post
import com.haur.domain.repositories.PostsRepository

class GetTopPostUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(): Resource<List<Post>> {
        return postsRepository.getTopPosts()
    }
}