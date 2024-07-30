package com.enoca.tmdb.network.di

import com.enoca.tmdb.network.AuthenticationInterceptor
import com.enoca.tmdb.network.SessionManager
import com.enoca.tmdb.network.TmdbApi
import com.enoca.tmdb.network.TmdbNetworkDataSource
import com.enoca.tmdb.network.retrofit.TmdbRetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Singleton
    @Provides
    fun providesSessionManager():SessionManager{
        return SessionManager()
    }

    @Singleton
    @Provides
    fun providesAuthenticationInterceptor(
        sessionManager: SessionManager
    ):AuthenticationInterceptor=AuthenticationInterceptor(sessionManager = sessionManager)

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthenticationInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    @Singleton
    @Provides
    fun provideTmdbApi(
        okHttpClient: OkHttpClient
    ):TmdbApi{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(TmdbApi::class.java)
    }

    @Singleton
    @Provides
    fun bindTmdbNetworkDataSource(instance:TmdbRetrofitDataSource):TmdbNetworkDataSource {
        return instance
    }
}