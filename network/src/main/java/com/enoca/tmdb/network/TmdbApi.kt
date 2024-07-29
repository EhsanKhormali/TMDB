package com.enoca.tmdb.network

import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface TmdbApi {

    @GET("authentication")
    suspend fun validateKey():Response<Any>


}