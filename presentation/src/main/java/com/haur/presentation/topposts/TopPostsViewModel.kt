package com.haur.presentation.topposts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.haur.data.di.PagingSourceFactory
import com.haur.data.services.PostPagingRemoteDataSource
import com.haur.domain.models.Post
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class TopPostsUiState(
    val isLoading: Boolean,
    val isRefreshing: Boolean = false
)

class TopPostsViewModel(
    private val postsPagingSourceFactory: PagingSourceFactory
): ViewModel() {

    private val _uiState = MutableStateFlow(TopPostsUiState(isLoading = true))
    val uiState: StateFlow<TopPostsUiState> = _uiState.asStateFlow()

    val postsFlow: Flow<PagingData<Post>> = Pager(PagingConfig(10)){
        postsPagingSourceFactory.getPostsPagingSource()
    }.flow.cachedIn(viewModelScope)

    init {
        _uiState.update { it.copy(
            isRefreshing = false,
            isLoading = true
        ) }
        fetchTopPosts()
    }


    private fun fetchTopPosts() {
        viewModelScope.launch {
            _uiState.update { it.copy(
                isLoading = false,
                isRefreshing = false
            ) }
        }
    }
}