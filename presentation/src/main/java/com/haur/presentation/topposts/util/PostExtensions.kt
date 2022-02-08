package com.haur.presentation.topposts.util

import com.haur.domain.models.Post
import java.util.*
import java.util.concurrent.TimeUnit

fun Post.createdDisplayTime(): String {
    val past = this.entryDate
    val now = Date()
    val seconds = TimeUnit.MILLISECONDS.toSeconds(now.time - past.time)
    val hours = TimeUnit.MILLISECONDS.toHours(now.time - past.time)
    val days = TimeUnit.MILLISECONDS.toDays(now.time - past.time)
    val years = days/360

    return when {
        years > 0 -> if (years.toInt() == 1) "$years Year Ago" else "$years Years Ago"
        days > 0 -> if (days.toInt() == 1) "$days Day Ago" else "$days Year Ago"
        hours > 0 -> if (days.toInt() == 1) "$hours Hour Ago" else "$hours Hours Ago"
        else -> "$seconds seconds ago"
    }
}