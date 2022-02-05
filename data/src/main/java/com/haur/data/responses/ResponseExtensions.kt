package com.haur.data.responses

import com.haur.domain.models.Post
import java.util.*
import kotlin.collections.ArrayList

fun PostsRequestResponse.toPostList() : List<Post> {
    val posts = ArrayList<Post>()

    this.data.children.map { children ->
        val post = children.data
        val newPost = Post(
            id = post.id,
            title = post.title,
            authorName = post.author,
            numberOfComments = post.num_comments,
            isRead = false,
            thumbnail = post.thumbnail,
            entryDate = createdToDisplayDate(post.created_utc),
            image = children.data.preview.images[0].source.url,
            text = children.data.author_flair_text
        )

        posts.add(newPost)
    }
    return posts
}

private fun createdToDisplayDate(timeStamp: Double): String {
    val date = Date(timeStamp.toLong())
    return date.toString()
}