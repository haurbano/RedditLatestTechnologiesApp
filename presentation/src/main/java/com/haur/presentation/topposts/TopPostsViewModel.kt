package com.haur.presentation.topposts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haur.domain.commons.successOr
import com.haur.domain.models.Post
import com.haur.domain.usecases.GetTopPostUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class TopPostsUiState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean,
    val isRefreshing: Boolean = false
)

class TopPostsViewModel(
    private val getTopPostUseCase: GetTopPostUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(TopPostsUiState(isLoading = true))
    val uiState: StateFlow<TopPostsUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(
            posts = emptyList(),
            isRefreshing = false,
            isLoading = true
        ) }
        fetchTopPosts()
    }

    fun refresh() {
        _uiState.update { it.copy(
            posts = emptyList(),
            isRefreshing = true,
            isLoading = false
        ) }
        fetchTopPosts()
    }


    private fun fetchTopPosts() {
        viewModelScope.launch {
            val posts = getTopPostUseCase()
            _uiState.update { it.copy(
                posts = posts.successOr(emptyList()),
                isLoading = false,
                isRefreshing = false
            ) }
        }
    }
}