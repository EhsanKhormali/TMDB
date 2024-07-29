package com.enoca.tmdb.network

import com.enoca.tmdb.network.model.MovieDto
import com.enoca.tmdb.network.model.NowPlayingResponse

interface TmdbNetworkDataSource {
    suspend fun getNowPlaying(page:Int): NowPlayingResponse
    suspend fun getPopular():List<MovieDto>
    suspend fun getTopRated():List<MovieDto>
    suspend fun upcoming():List<MovieDto>
}