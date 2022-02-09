package com.haur.presentation.topposts

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.haur.domain.models.Post
import com.haur.presentation.R
import com.haur.presentation.topposts.util.createdDisplayTime

@Composable
fun TopPostsScreen(viewModel: TopPostsViewModel){
    val uiState by viewModel.uiState.collectAsState()
    val posts = viewModel.postsFlow.collectAsLazyPagingItems()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = uiState.isRefreshing),
        onRefresh = { posts.refresh() }
    ) {

        LazyColumn(
            Modifier.padding(start = 8.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(posts) { post ->
                post?.let { PostItem(post, {}) }
            }
        }
    }

}
@Composable
fun PostItem(
    post: Post,
    onThumbnailClick: () -> Unit
){
    Column() {
        PostTitle(title = post.title)
        PostAuthor(author= post.authorName)
        if (post.thumbnail.isNotEmpty()){
            PostImage(url = post.thumbnail, onThumbnailClick)
        }
        PostInfo(post)
        Divider(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 16.dp),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f)
        )
    }
}

@Composable
fun PostInfo(post: Post) {
    Row(modifier = Modifier.padding(top= 8.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_comment_24),
            contentDescription = null
        )

        Text(
            text = post.numberOfComments.toString(),
            modifier = Modifier.padding(start = 4.dp),
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_access_time_24),
            contentDescription = null
        )

        Text(
            text = post.createdDisplayTime(),
            modifier = Modifier.padding(start = 4.dp),
        )
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