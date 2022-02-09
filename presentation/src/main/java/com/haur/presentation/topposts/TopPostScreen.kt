package com.haur.presentation.topposts

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.haur.presentation.topposts.composables.PostItem
import com.haur.presentation.topposts.util.createdDisplayTime

@ExperimentalAnimationApi
@Composable
fun TopPostsScreen(viewModel: TopPostsViewModel){
    val uiState by viewModel.uiState.collectAsState()
    val posts = viewModel.postsFlow.collectAsLazyPagingItems()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = uiState.isRefreshing || uiState.isLoading),
        onRefresh = { posts.refresh() },
        modifier = Modifier.padding(top = 8.dp)
    ) {
        LazyColumn(
            Modifier.padding(start = 8.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(posts) { post ->
                post?.let {
                    AnimatedRemove(
                        shouldBeVisible= {viewModel.isDismissed(post.id)}
                    ) {
                        Card(elevation = 4.dp, modifier = Modifier.padding(4.dp)) {
                            PostItem(post, {}, { viewModel.dismissPost(it) })
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimatedRemove(
    shouldBeVisible: () -> Boolean,
    content: @Composable() AnimatedVisibilityScope.() -> Unit
){
    AnimatedVisibility(
        visible = !shouldBeVisible(),
        enter = expandVertically(),
        exit = shrinkVertically(animationSpec = tween(durationMillis = 700))
    ) {
       content()
    }
}