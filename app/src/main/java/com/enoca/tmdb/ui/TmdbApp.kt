package com.enoca.tmdb.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration.Short
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult.ActionPerformed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.enoca.tmdb.navigation.Home
import com.enoca.tmdb.navigation.TmdbNavigation
import com.enoca.tmdb.navigation.TopLevelDestination
import com.enoca.tmdb.ui.theme.GradientColors
import com.enoca.tmdb.ui.theme.LocalGradientColors
import kotlin.math.tan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TmdbApp(){
    val snackbarHostState = remember { SnackbarHostState() }
    val navController= rememberNavController()
    val currentScreen :MutableState<TopLevelDestination> = remember {
        mutableStateOf(TopLevelDestination.Home)
    }

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            TmdbBottomNavigation(
                currentScreen =currentScreen.value.screen,
                onNavigate = {
                    currentScreen.value=it
                    navController.navigate(it.screen){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
            }
            )
        }
    ) {padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            CenterAlignedTopAppBar(
                title = { Text(text = "TMDB") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "actionIconContentDescription",
                            tint = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent,
                )
            )
            Box(
                modifier = Modifier.consumeWindowInsets(
                    if (true) {
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Top)
                    } else {
                        WindowInsets(0, 0, 0, 0)
                    },
                ),
            ) {
                TmdbNavigation(
                    navController = navController,
                    startingScreen = Home,
                    onShowSnackbar = { message, action ->
                        snackbarHostState.showSnackbar(
                            message = message,
                            actionLabel = action,
                            duration = Short,
                        ) == ActionPerformed
                    },
                )
            }
        }
    }
}

@Composable
fun TmdbBottomNavigation(
    currentScreen:Any,
    onNavigate: (TopLevelDestination) -> Unit,
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets= NavigationBarDefaults.windowInsets
) {
    val bottomNavigation = listOf(
        TopLevelDestination.Home,
        TopLevelDestination.Search,
        TopLevelDestination.Movie
        )
    NavigationBar(
        modifier = modifier,
        windowInsets = windowInsets
    ) {

        bottomNavigation.forEach {
            val selected= currentScreen::class==it.screen::class
            NavigationBarItem(
                onClick = {
                    onNavigate(it)
                },
                icon = {
                    Icon(
                        imageVector = if (selected) it.selectedIcon else it.unselectedIcon,
                        contentDescription = "navigation Icon"
                    )
                },
                label = { Text(it.iconText) },
                selected = selected
            )
        }

    }
}

@Composable
fun TmdbGradientBackground(
    modifier: Modifier = Modifier,
    gradientColors: GradientColors = LocalGradientColors.current,
    content: @Composable () -> Unit,
) {
    val currentTopColor by rememberUpdatedState(gradientColors.top)
    val currentBottomColor by rememberUpdatedState(gradientColors.bottom)
    Surface(
        color = if (gradientColors.container == Color.Unspecified) {
            Color.Transparent
        } else {
            gradientColors.container
        },
        modifier = modifier.fillMaxSize(),
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .drawWithCache {
                    // Compute the start and end coordinates such that the gradients are angled 11.06
                    // degrees off the vertical axis
                    val offset = size.height * tan(
                        Math
                            .toRadians(11.06)
                            .toFloat(),
                    )

                    val start = Offset(size.width / 2 + offset / 2, 0f)
                    val end = Offset(size.width / 2 - offset / 2, size.height)

                    // Create the top gradient that fades out after the halfway point vertically
                    val topGradient = Brush.linearGradient(
                        0f to if (currentTopColor == Color.Unspecified) {
                            Color.Transparent
                        } else {
                            currentTopColor
                        },
                        0.724f to Color.Transparent,
                        start = start,
                        end = end,
                    )
                    // Create the bottom gradient that fades in before the halfway point vertically
                    val bottomGradient = Brush.linearGradient(
                        0.2552f to Color.Transparent,
                        1f to if (currentBottomColor == Color.Unspecified) {
                            Color.Transparent
                        } else {
                            currentBottomColor
                        },
                        start = start,
                        end = end,
                    )

                    onDrawBehind {
                        // There is overlap here, so order is important
                        drawRect(topGradient)
                        drawRect(bottomGradient)
                    }
                },
        ) {
            content()
        }
    }
}