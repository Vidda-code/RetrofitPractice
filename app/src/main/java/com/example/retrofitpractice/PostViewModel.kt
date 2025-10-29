package com.example.retrofitpractice

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class UiState {
    object Loading : UiState()
    data class Success(val posts: List<PostResponse>) : UiState()
    data class Error(val message: String) : UiState()
}

class PostViewModel {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _uiState

    private val postsRepository = Repository()

    
    private suspend fun fetchPosts(){

            _uiState.value = UiState.Loading
            try {
                val posts = postsRepository.getPosts()
                _uiState.value = UiState.Success(posts)

            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to fetch posts")
            }
    }
}