package com.haur.presentation.topposts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun TopPostsScreen(viewModel: TopPostsViewModel){
    val uiState by viewModel.uiState.collectAsState()

    Column() {
        uiState.posts.forEach { post ->
            Text(post.title)
        }
    }

}