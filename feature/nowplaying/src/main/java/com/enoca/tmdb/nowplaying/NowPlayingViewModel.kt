package com.enoca.tmdb.nowplaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enoca.tmdb.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        NowPlayingUiState(movies = listOf())
    )
    val uiState = _uiState.asStateFlow()

    init{
        viewModelScope.launch {
            val movies = repository.getNowPlayingMovies(1).movies
            if (movies != null)
                _uiState.update {
                    it.copy(movies = movies)
                }
        }
    }
}