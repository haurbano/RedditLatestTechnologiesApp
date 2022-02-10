package com.haur.data

import androidx.paging.PagingSource
import com.haur.data.responses.PostResponseMapper
import com.haur.data.responses.PostsRequestResponse
import com.haur.data.services.PostPagingRemoteDataSource
import com.haur.data.services.TopPostRemoteService
import com.haur.domain.models.Post
import com.haur.domain.repositories.PostsRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class PostPagingRemoteDataSourceTest {

    private val topPostRemoteService = mockk<TopPostRemoteService>()
    private val postsRepository = mockk<PostsRepository>()
    private val responseMapper = mockk<PostResponseMapper>()
    private val response = mockk<PostsRequestResponse>()

    private val pagingRemoteService = PostPagingRemoteDataSource(
        topPostRemoteService,
        postsRepository,
        responseMapper
    )

    @Test
    fun dismissedPostShouldNotBeIncluded() = runBlocking {
        // Given
        val posts = listOf(
            getFakePost().copy(id = "dismissed"),
            getFakePost().copy(id = "Not dismissed"),
            getFakePost().copy(id = "Not dismissed")
        )

        coEvery { topPostRemoteService.getPosts() } returns response
        coEvery { responseMapper.toPostList(any()) } returns posts
        coEvery { postsRepository.isPostAlreadyRead(any()) } returns false
        coEvery { postsRepository.isPostDismissed("dismissed") } returns true
        coEvery { postsRepository.isPostDismissed("Not dismissed") } returns false


        // When
        val response = pagingRemoteService.load(
            PagingSource.LoadParams.Refresh(
                key= null,
                loadSize = 3,
                placeholdersEnabled = false
            )
        )

        val expected = PagingSource.LoadResult.Page(
            data = listOf(posts[1], posts[2]),
            prevKey = posts[1].after,
            nextKey = posts[2].after
        )

        // Then
        assertEquals(response, expected)
    }

    private fun getFakePost(): Post {
        return Post(
            isRead = false,
            id = "id",
            title = "title",
            authorName = "Author",
            entryDate = Date(),
            thumbnail = "Fake URL",
            numberOfComments = 20,
            images = emptyList(),
            text = "Post Content",
            after = "empty after"
        )
    }
}