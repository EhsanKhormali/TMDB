package com.enoca.tmdb.data.repository

import com.enoca.tmdb.network.TmdbNetworkDataSource
import com.enoca.tmdb.network.model.NowPlayingResponse
import com.enoca.tmdb.network.model.PopularResponse


class MovieRepository (private val api:TmdbNetworkDataSource) {
    suspend fun getNowPlayingMovies(page:Int): NowPlayingResponse {
        return api.getNowPlaying(page)
    }

    suspend fun getPopularMovies(page:Int): PopularResponse {
        return api.getPopular(page)
    }

    suspend fun getTopRatedMovies(page:Int): PopularResponse {
        return api.getTopRated(page)
    }

    suspend fun getUpcomingMovies(page:Int): NowPlayingResponse {
        return api.upcoming(page)
    }
}