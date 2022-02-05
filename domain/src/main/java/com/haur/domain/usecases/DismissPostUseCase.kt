package com.haur.domain.usecases

import com.haur.domain.commons.Result
import com.haur.domain.repositories.PostsRepository

class DismissPostUseCase(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(id: String): Result<Boolean> {
        return postsRepository.dismissPost(id)
    }
}