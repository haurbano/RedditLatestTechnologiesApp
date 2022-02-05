package com.haur.data.services

import com.haur.domain.commons.Resource

interface PostLocalService {
    fun checkPostAsRead(id: String): Resource<Boolean>
    fun dismissPost(id: String): Resource<Boolean>
    fun isPostDismissed(id: String): Resource<Boolean>
    fun isPostAlreadyRead(id: String): Resource<Boolean>
}