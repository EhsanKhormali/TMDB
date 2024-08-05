package com.enoca.tmdb.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
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
        MovieSource(repository,1)
    }.flow
        .cachedIn(viewModelScope)

}