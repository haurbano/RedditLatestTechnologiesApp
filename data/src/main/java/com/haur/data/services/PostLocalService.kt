package com.haur.data.services

import com.haur.domain.commons.Result

interface PostLocalService {
    fun checkPostAsRead(id: String): Result<Boolean>
    fun dismissPost(id: String): Result<Boolean>
    fun isPostDismissed(id: String): Boolean
    fun isPostAlreadyRead(id: String): Boolean
}