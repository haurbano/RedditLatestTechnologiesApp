package com.haur.data.services.impl

import android.content.Context
import android.content.SharedPreferences
import com.haur.data.services.PostLocalService
import com.haur.domain.commons.Result

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

    override fun checkPostAsRead(id: String): Result<Boolean> {
        readPostSharedPreferences.edit().putBoolean(id, true).apply()
        return Result.Success(true)
    }

    override fun dismissPost(id: String): Result<Boolean> {
        dismissPostSharedPreferences.edit().putBoolean(id, true).apply()
        return Result.Success(true)
    }

    override fun isPostDismissed(id: String): Result<Boolean> {
        val isDismissed = dismissPostSharedPreferences.contains(id)
        return Result.Success(isDismissed)
    }

    override fun isPostAlreadyRead(id: String): Result<Boolean> {
        val isRead = readPostSharedPreferences.contains(id)
        return Result.Success(isRead)
    }


}