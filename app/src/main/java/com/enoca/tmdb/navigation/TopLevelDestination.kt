package com.enoca.tmdb.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconText: String,
    val titleText: String,
    val screen:Any
) {
    data object Home:TopLevelDestination(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconText = "Home",
        titleText = "Home",
        screen = com.enoca.tmdb.navigation.Home
    )
    data object Search:TopLevelDestination(
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        iconText = "Search",
        titleText = "Search",
        screen = com.enoca.tmdb.navigation.Search
    )
        data object Movie:TopLevelDestination(
        selectedIcon = Icons.Filled.Movie,
        unselectedIcon = Icons.Outlined.Movie,
        iconText = "Movie",
        titleText = "Movie",
            screen = com.enoca.tmdb.navigation.Movie
    )
}