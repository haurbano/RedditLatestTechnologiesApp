package com.haur.presentation.topposts.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.haur.domain.models.Post
import com.haur.presentation.R
import com.haur.presentation.topposts.util.createdDisplayTime

@Composable
fun PostItem(
    post: Post,
    dismissPost: (String) -> Unit,
    postIsRead: () -> Boolean
){
    Column(modifier = Modifier.padding(8.dp)) {
        PostTitle(title = post.title, postIsRead, post)
        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PostAuthor(author= post.authorName)
            Spacer(modifier = Modifier.size(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_access_time_24),
                contentDescription = null
            )
            Text(
                text = post.createdDisplayTime(),
                modifier = Modifier.padding(start = 4.dp),
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.4f)
            )
        }
        if (post.thumbnail.isNotEmpty()){
            PostImage(url = post.thumbnail)
        }
        PostInfo(post, dismissPost)
    }
}

@Composable
fun PostInfo(post: Post, dismissPost: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CommentsInfo(post)
        Spacer(modifier = Modifier.width(16.dp))
        DismissIcon(dismissPost, post)

    }
}

@Composable
private fun CommentsInfo(post: Post) {
    Icon(
        modifier= Modifier.padding(start= 4.dp),
        painter = painterResource(id = R.drawable.ic_baseline_comment_24),
        contentDescription = null
    )

    Text(
        text = post.numberOfComments.toString(),
        modifier = Modifier.padding(start = 4.dp),
    )
}

@Composable
fun DismissIcon(dismissPost: (String) -> Unit, post: Post) {
    IconButton(
        onClick = { dismissPost(post.id) },
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter= painterResource(id = R.drawable.ic_baseline_block_24),
                tint = Color.Red,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Dismiss", modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun PostAuthor(author: String) {
    Text(
        text = author,
        style = MaterialTheme.typography.subtitle2,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.4f)
    )
}

@Composable
fun PostImage(url: String) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                placeholder(R.drawable.ic_baseline_error_outline_24)
            }
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp)
            .padding(4.dp)
            .clip(shape = MaterialTheme.shapes.medium)
    )
}

@Composable
fun PostTitle(title: String, isRead: () -> Boolean, post: Post){
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (!isRead() && !post.isRead) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_fiber_new_24),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}