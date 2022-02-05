package com.haur.domain.usecases

import com.haur.domain.repositories.PostsRepository
import com.haur.domain.commons.Result

class CheckPostAsReadUseCase(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(id: String): Result<Boolean> {
        return postsRepository.checkPostAsRead(id)
    }
}