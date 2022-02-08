package com.haur.data.responses

import com.haur.domain.models.Post
import java.sql.Timestamp
import java.util.*
import kotlin.collections.ArrayList

fun PostsRequestResponse.toPostList() : List<Post> {
    val posts = ArrayList<Post>()

    this.data.children.map { children ->
        val post = children.data
        val postImages = children.data.preview?.images ?: emptyList()
        val newPost = Post(
            id = post.id,
            title = post.title,
            authorName = post.author,
            numberOfComments = post.num_comments,
            isRead = false,
            thumbnail = post.thumbnail,
            entryDate = parseDate(post.created),
            images = postImages.map { it.source.url },
            text = children.data.author_flair_text
        )

        posts.add(newPost)
    }
    return posts
}

private fun parseDate(timeStamp: Long): Date {
    val ts = Timestamp(timeStamp)
    return Date(ts.time)
}