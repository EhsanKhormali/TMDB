package com.enoca.tmdb.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.enoca.tmdb.data.model.MovieListType
import com.enoca.tmdb.data.repository.MovieRepository
import com.enoca.tmdb.data.repository.paged.MovieSource
import com.enoca.tmdb.network.model.MovieDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
):ViewModel() {
    val nowplaying :  Flow<PagingData<MovieDto>> = Pager(PagingConfig(pageSize = 10)){
        MovieSource(repository, MovieListType.NOW_PLAYING)
    }.flow
        .cachedIn(viewModelScope)
    val popular :  Flow<PagingData<MovieDto>> = Pager(PagingConfig(pageSize = 10)){
        MovieSource(repository, MovieListType.POPULAR)
    }.flow
        .cachedIn(viewModelScope)
    val topRated :  Flow<PagingData<MovieDto>> = Pager(PagingConfig(pageSize = 10)){
        MovieSource(repository, MovieListType.TOP_RATED)
    }.flow
        .cachedIn(viewModelScope)
    val upcoming :  Flow<PagingData<MovieDto>> = Pager(PagingConfig(pageSize = 10)){
        MovieSource(repository, MovieListType.UPCOMING)
    }.flow
        .cachedIn(viewModelScope)

}