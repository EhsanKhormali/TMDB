package com.enoca.tmdb.data.repository

import com.enoca.tmdb.network.TmdbApi
import com.enoca.tmdb.network.TmdbNetworkDataSource
import com.enoca.tmdb.network.model.NowPlayingResponse
import javax.inject.Inject


class MovieRepository (private val api:TmdbNetworkDataSource) {
    suspend fun getNowPlayingMovies(page:Int): NowPlayingResponse {
        return api.getNowPlaying(page)
    }
}