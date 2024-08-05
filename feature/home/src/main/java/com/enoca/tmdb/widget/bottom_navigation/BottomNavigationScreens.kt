package com.enoca.tmdb.widget.bottom_navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreen(
    val text: String,
    val icon: ImageVector
) {
    data object HomeNav : BottomNavigationScreen(
        text="Home",
        icon = Icons.Default.Home
    )


    data object Products : BottomNavigationScreen(
        text = "series",
        icon = Icons.Default.MailOutline
    )
}
