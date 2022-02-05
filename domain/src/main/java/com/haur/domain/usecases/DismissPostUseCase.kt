package com.haur.domain.usecases

import com.haur.domain.commons.Resource
import com.haur.domain.repositories.PostsRepository

class DismissPostUseCase(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(id: String): Resource<Boolean> {
        return postsRepository.dismissPost(id)
    }
}