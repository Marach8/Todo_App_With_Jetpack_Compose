package com.example.todoapp.bottom_navigation_bar.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.ContentAlpha
import com.example.todoapp.bottom_navigation_bar.bottom_bar.BottomNavGraph
import com.example.todoapp.bottom_navigation_bar.bottom_bar.BottomNavScreens

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNav(navController = navController) }
    ) {
        innerPadding -> Box(
        modifier = Modifier.padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomNav(navController: NavHostController){
    val screens = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.Profile,
        BottomNavScreens.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach(){
            screen -> NavigationBarItem(
                label = {Text(text = screen.title)},
                icon = {Icon(imageVector = screen.icon, contentDescription = "Icon")},
                selected = currentDestination?.hierarchy?.any{
                    it.route == screen.route
                } == true,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier.alpha(1f),
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                    unselectedTextColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
                )
            )
        }
    }
}