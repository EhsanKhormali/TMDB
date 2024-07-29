package com.enoca.tmdb.network.retrofit

import com.enoca.tmdb.network.TmdbApi
import com.enoca.tmdb.network.TmdbNetworkDataSource
import com.enoca.tmdb.network.model.MovieDto
import com.enoca.tmdb.network.model.NowPlayingResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TmdbRetrofitDataSource @Inject constructor(private val api: TmdbApi):TmdbNetworkDataSource  {
    override suspend fun getNowPlaying(page:Int): NowPlayingResponse {
        return api.getNowPlaying(page)
    }

    override suspend fun getPopular(): List<MovieDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopRated(): List<MovieDto> {
        TODO("Not yet implemented")
    }

    override suspend fun upcoming(): List<MovieDto> {
        TODO("Not yet implemented")
    }

}