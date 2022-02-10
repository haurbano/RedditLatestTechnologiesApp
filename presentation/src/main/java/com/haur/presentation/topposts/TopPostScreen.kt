package com.haur.presentation.topposts

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.haur.presentation.navigation.NavDestinations
import com.haur.presentation.topposts.composables.PostItem

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun TopPostsScreen(viewModel: TopPostsViewModel, navController: NavController){
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
                        Card(
                            elevation = 4.dp,
                            modifier = Modifier.padding(4.dp),
                            onClick = {
                                viewModel.markPostAsRead(post.id)
                                navController.navigate(
                                    NavDestinations.PostDetails+"/${post.title}"
                                )
                            }
                        ) {
                            PostItem(
                                post = post,
                                dismissPost = { viewModel.dismissPost(it) },
                                postIsRead = { viewModel.isRead(it.id)}
                            )
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