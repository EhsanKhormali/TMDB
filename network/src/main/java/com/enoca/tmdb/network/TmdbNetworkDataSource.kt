package com.enoca.tmdb.network

import com.enoca.tmdb.network.model.MovieDto
import com.enoca.tmdb.network.model.NowPlayingResponse
import com.enoca.tmdb.network.model.PopularResponse
import com.enoca.tmdb.network.model.UserDataDto

interface TmdbNetworkDataSource {
    suspend fun getNowPlaying(page:Int): NowPlayingResponse
    suspend fun getPopular(page:Int): PopularResponse
    suspend fun getTopRated(page:Int): PopularResponse
    suspend fun upcoming(page:Int):NowPlayingResponse
    suspend fun getUserData(): UserDataDto
}