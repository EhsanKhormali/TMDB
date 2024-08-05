package com.enoca.tmdb.network.retrofit

import com.enoca.tmdb.network.TmdbApi
import com.enoca.tmdb.network.TmdbNetworkDataSource
import com.enoca.tmdb.network.model.MovieDto
import com.enoca.tmdb.network.model.NowPlayingResponse
import com.enoca.tmdb.network.model.PopularResponse
import com.enoca.tmdb.network.model.UserDataDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TmdbRetrofitDataSource @Inject constructor(private val api: TmdbApi):TmdbNetworkDataSource  {
    override suspend fun getNowPlaying(page:Int): NowPlayingResponse {
        return api.getNowPlaying(page)
    }

    override suspend fun getPopular(page: Int): PopularResponse {
        return api.getPopular(page)
    }

    override suspend fun getTopRated(page: Int): PopularResponse {
        return api.getTopRated(page)
    }

    override suspend fun upcoming(page: Int): NowPlayingResponse {
        return api.getUpcoming(page)
    }

    override suspend fun getUserData(): UserDataDto {
        return api.getUserData()
    }

}