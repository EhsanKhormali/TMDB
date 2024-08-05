package com.enoca.tmdb.navigation

import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enoca.tmdb.home.HomeScreen


@Composable
fun TmdbNavigation(navController: NavHostController, startingScreen: Any) {

    NavHost(
        navController = navController,
        startDestination = startingScreen,
        modifier = Modifier.safeDrawingPadding()
    ) {

        composable<Home> {
            HomeScreen()
        }
    }
}