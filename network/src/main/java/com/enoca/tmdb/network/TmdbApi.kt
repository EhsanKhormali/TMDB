package com.enoca.tmdb.network

import com.enoca.tmdb.network.model.NowPlayingResponse
import com.enoca.tmdb.network.model.PopularResponse
import com.enoca.tmdb.network.model.UserDataDto
import com.enoca.tmdb.network.model.ValidationResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface TmdbApi {

    @GET("authentication")
    suspend fun validateKey():Response<ValidationResult>
    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page:Int):NowPlayingResponse
    @GET("account")
    suspend fun getUserData(): UserDataDto
    @GET("movie/popular")
    suspend fun getPopular(@Query("page") page:Int):PopularResponse
    @GET("movie/top_rated")
    suspend fun getTopRated(@Query("page") page:Int):PopularResponse
    @GET("movie/upcoming")
    suspend fun getUpcoming(@Query("page") page:Int):NowPlayingResponse

}