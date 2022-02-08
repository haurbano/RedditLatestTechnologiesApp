package com.haur.domain.models

import java.io.Serializable
import java.util.*

data class Post(
    val id: String,
    val title: String,
    val authorName: String,
    val entryDate: Date,
    val thumbnail: String,
    val numberOfComments: Int,
    var isRead: Boolean,
    var images: List<String>,
    var text: String?
) : Serializable