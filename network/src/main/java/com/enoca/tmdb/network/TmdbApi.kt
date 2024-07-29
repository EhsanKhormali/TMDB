package com.enoca.tmdb.network

import com.enoca.tmdb.network.model.NowPlayingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface TmdbApi {

    @GET("authentication")
    suspend fun validateKey():Response<Any>
    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page:Int):NowPlayingResponse
}