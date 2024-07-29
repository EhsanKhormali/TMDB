package com.enoca.tmdb.data.repository

import com.enoca.tmdb.network.TmdbApi
import com.enoca.tmdb.network.model.NowPlayingResponse
import javax.inject.Inject


class MovieRepository @Inject constructor(private val api:TmdbApi) {
    suspend fun getNowPlayingMovies(page:Int): NowPlayingResponse {
        return api.getNowPlaying(page)
    }
}