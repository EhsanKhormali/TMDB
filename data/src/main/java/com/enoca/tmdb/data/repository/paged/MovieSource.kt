package com.enoca.tmdb.data.repository.paged

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.enoca.tmdb.data.model.MovieListType
import com.enoca.tmdb.data.repository.MovieRepository
import com.enoca.tmdb.network.model.MovieDto

class MovieSource(private val movieService: MovieRepository,private val listType:MovieListType) :
    PagingSource<Int, MovieDto>() {
    /// The refresh key is used for the initial load of the next PagingSource, after invalidation
    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        return try {
            val nextPage = params.key ?: 1
            var totalPages = 1
            val movieListResponse =
                when(listType) {
                    MovieListType.NOW_PLAYING -> {
                        val result =movieService.getNowPlayingMovies(nextPage)
                        totalPages=result.totalPages?:1
                        result.movies
                    }

                    MovieListType.POPULAR -> {
                        val result =movieService.getPopularMovies(nextPage)
                        totalPages=result.totalPages?:1
                        result.results
                    }
                    MovieListType.UPCOMING -> {
                        val result =movieService.getUpcomingMovies(nextPage)
                        totalPages=result.totalPages?:1
                        result.movies
                    }
                    MovieListType.TOP_RATED -> {
                        val result =movieService.getTopRatedMovies(nextPage)
                        totalPages=result.totalPages?:1
                        result.results
                    }
                    else -> {
                        val result =movieService.getNowPlayingMovies(nextPage)
                        totalPages=result.totalPages?:1
                        result.movies
                    }
                }

            LoadResult.Page(
                data = movieListResponse ?: emptyList(),
                prevKey = if (nextPage == 1) null else nextPage.minus(1),
                nextKey = nextPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}