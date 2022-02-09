package com.haur.presentation

import com.haur.domain.models.Post
import com.haur.presentation.topposts.util.createdDisplayTime
import org.junit.Test
import java.util.*

class PostUtilsTest {
    val post = Post(
        id = "id",
        title = "title",
        authorName = "Name",
        entryDate = Date(),
        thumbnail = "thumbnail url",
        numberOfComments = 20,
        isRead = false,
        images = emptyList(),
        text = null,
        after = ""
    )

    @Test
    fun `when created date is 1 day ago createDisplayTime should return 1 day ago`() {
        // Given
        var entryDate: Date
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        entryDate = calendar.time
        val postYearAgo = post.copy(entryDate = entryDate)

        // When
        val message = postYearAgo.createdDisplayTime()

        // Then
        assert(message == "1 Day Ago")
    }

    @Test
    fun `when created date is 2 hour ago createDisplayTime should return 2 hours ago`() {
        // Given
        var entryDate: Date
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.HOUR, -2)
        entryDate = calendar.time
        val postYearAgo = post.copy(entryDate = entryDate)

        // When
        val message = postYearAgo.createdDisplayTime()

        // Then
        assert(message == "2 Hours Ago")
    }

    @Test
    fun `when created date is 3 Years ago createDisplayTime should return 3 hours ago`() {
        // Given
        var entryDate: Date
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.YEAR, -3)
        entryDate = calendar.time
        val postYearAgo = post.copy(entryDate = entryDate)

        // When
        val message = postYearAgo.createdDisplayTime()

        // Then
        assert(message == "3 Years Ago")
    }
}