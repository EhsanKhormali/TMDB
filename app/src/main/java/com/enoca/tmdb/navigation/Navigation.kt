package com.enoca.tmdb.navigation

import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enoca.tmdb.feature.movie.MovieScreen
import com.enoca.tmdb.home.HomeScreen
import com.enoca.tmdb.feature.search.SearchScreen


@Composable
fun TmdbNavigation(
    navController: NavHostController,
    startingScreen: Any,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {

    NavHost(
        navController = navController,
        startDestination = startingScreen,
        modifier = Modifier.safeDrawingPadding()
    ) {

        composable<Home> {
            HomeScreen()
        }
        composable<Search> {
            SearchScreen()
        }
        composable<Movie> {
            MovieScreen()
        }
    }
}