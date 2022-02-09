package com.haur.presentation.topposts.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
    onThumbnailClick: () -> Unit,
    dismissPost: (String) -> Unit
){
    Column() {
        PostTitle(title = post.title)
        PostAuthor(author= post.authorName)
        if (post.thumbnail.isNotEmpty()){
            PostImage(url = post.thumbnail, onThumbnailClick)
        }
        PostInfo(post, dismissPost)
        Divider(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 16.dp),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f)
        )
    }
}

@Composable
fun PostInfo(post: Post, dismissPost: (String) -> Unit) {
    Row(modifier = Modifier.padding(top= 8.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_comment_24),
            contentDescription = null
        )

        Text(
            text = post.numberOfComments.toString(),
            modifier = Modifier.padding(start = 4.dp),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_access_time_24),
            contentDescription = null
        )

        Text(
            text = post.createdDisplayTime(),
            modifier = Modifier.padding(start = 4.dp),
        )

        Spacer(modifier = Modifier.width(16.dp))

        IconButton(
            onClick = { dismissPost(post.id) },
        ){
            Icon(
                painter= painterResource(id = R.drawable.ic_baseline_block_24),
                tint = Color.Red,
                contentDescription = null
            )
        }

    }
}

@Composable
fun PostAuthor(author: String) {
    Text(
        text = author,
        style = MaterialTheme.typography.subtitle2,
        modifier = Modifier.padding(top = 10.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.4f)
    )
}

@Composable
fun PostImage(url: String, onClickImage: () -> Unit) {
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
            .padding(top = 8.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClickImage() }
    )
}

@Composable
fun PostTitle(title: String){
    Text(
        text = title,
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.padding(top = 8.dp)
    )
}