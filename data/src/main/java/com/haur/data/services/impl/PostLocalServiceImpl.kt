package com.haur.data.services.impl

import android.content.Context
import android.content.SharedPreferences
import com.haur.data.services.PostLocalService
import com.haur.domain.commons.Resource

class PostLocalServiceImpl(
    private val context: Context
) : PostLocalService{

    companion object {
        private const val READ_POSTS_PREFERENCES = "ReadPostPreferences"
        private const val REMOVED_POSTS_PREFERENCES = "RemovedPostPreferences"
    }

    private val readPostSharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(READ_POSTS_PREFERENCES, Context.MODE_PRIVATE)
    }

    private val dismissPostSharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(REMOVED_POSTS_PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun checkPostAsRead(id: String): Resource<Boolean> {
        readPostSharedPreferences.edit().putBoolean(id, true).apply()
        return Resource.Success(true)
    }

    override fun dismissPost(id: String): Resource<Boolean> {
        dismissPostSharedPreferences.edit().putBoolean(id, true).apply()
        return Resource.Success(true)
    }

    override fun isPostDismissed(id: String): Resource<Boolean> {
        val isDismissed = dismissPostSharedPreferences.contains(id)
        return Resource.Success(isDismissed)
    }

    override fun isPostAlreadyRead(id: String): Resource<Boolean> {
        val isRead = readPostSharedPreferences.contains(id)
        return Resource.Success(isRead)
    }


}