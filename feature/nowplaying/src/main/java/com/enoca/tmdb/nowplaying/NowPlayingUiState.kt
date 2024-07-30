package com.enoca.tmdb.nowplaying

import com.enoca.tmdb.network.model.MovieDto

data class NowPlayingUiState(
    val movies:List<MovieDto>
)
