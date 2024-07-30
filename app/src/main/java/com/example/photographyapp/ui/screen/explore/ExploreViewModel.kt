package com.example.photographyapp.ui.screen.explore

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photographyapp.model.UnsplashPhoto
import com.example.photographyapp.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val repository: UnsplashRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        loadPhotos()
    }

    fun loadPhotos() {
        viewModelScope.launch {
            repository.searchImage("cat")
                .onEach { _uiState.value = UiState.Success(it.results) }
                .catch { _uiState.value = UiState.Error(it) }
                .launchIn(viewModelScope)
        }
    }
}


sealed class UiState {
    data class Success(
        val result: List<UnsplashPhoto>
    ) : UiState()

    object Loading : UiState()
    data class Error(val exception: Throwable) : UiState()
}