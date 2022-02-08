package com.haur.data.services

import com.haur.data.responses.PostsRequestResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TopPostRemoteService {
    @GET("top/.json")
    suspend fun getPosts(
        @Query("limit") limit: String = ApiConfig.limit,
        @Query("t") t: String = ApiConfig.time,
        @Query("after") afterKey: String= ""
    ): PostsRequestResponse
}