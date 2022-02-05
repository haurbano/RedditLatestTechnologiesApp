package com.haur.domain.usecases

import com.haur.domain.repositories.PostsRepository
import com.haur.domain.commons.Resource

class CheckPostAsReadUseCase(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(id: String): Resource<Boolean> {
        return postsRepository.checkPostAsRead(id)
    }
}