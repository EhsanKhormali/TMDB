package com.enoca.tmdb.data.di

import com.enoca.tmdb.data.repository.MovieRepository
import com.enoca.tmdb.network.TmdbApi
import com.enoca.tmdb.network.TmdbNetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesMovieRepository(api:TmdbNetworkDataSource):MovieRepository{
        return MovieRepository(api)
    }
}