package com.example.todoapp.bottom_navigation_bar.bottom_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens (
    val title: String,
    val route: String,
    val icon: ImageVector
){
    data object Home: BottomNavScreens(
        title = "Home",
        route = "home_route",
        icon = Icons.Default.Home
    )
    data object Profile: BottomNavScreens(
        title = "Profile",
        route = "profile_route",
        icon = Icons.Default.Person
    )
    data object Settings: BottomNavScreens(
        "Settings",
        "settings_route",
        Icons.Outlined.Settings
    )
}