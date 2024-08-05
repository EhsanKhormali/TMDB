package com.enoca.tmdb.widget.bottom_navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun TmdbBottomNavigation(
    onNavigate: (Any) -> Unit,
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets=NavigationBarDefaults.windowInsets
) {
    val bottomNavigation = listOf(BottomNavigationScreen.HomeNav, BottomNavigationScreen.Products)
    NavigationBar(
        modifier = modifier,
        windowInsets = windowInsets
    ) {
        NavigationBarItem(
            onClick = {
            },
            icon = {
                Icon(
                    imageVector = bottomNavigation[0].icon,
                    contentDescription = "navigation Icon"
                )
            },
            label = { Text(bottomNavigation[0].text) },
            selected = true
        )

        SmallFloatingActionButton(
            onClick = {  },
            containerColor = MaterialTheme.colorScheme.primary,
            elevation = FloatingActionButtonDefaults.elevation(0.dp),
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                //modifier = Modifier.size(25.dp)
            )
        }

        NavigationBarItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(
                    imageVector = bottomNavigation[1].icon,
                    contentDescription = "navigation Icon"
                )
            },
            label = { Text(bottomNavigation[1].text) }
        )

    }
}