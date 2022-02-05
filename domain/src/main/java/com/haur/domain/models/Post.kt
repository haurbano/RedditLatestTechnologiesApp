package com.haur.domain.models

import java.io.Serializable

data class Post(
    val id: String,
    val title: String,
    val authorName: String,
    val entryDate: String,
    val thumbnail: String,
    val numberOfComments: Int,
    var isRead: Boolean,
    var image: String,
    var text: String?
) : Serializable