package com.example.todoapp.bottom_navigation_bar.bottom_bar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoapp.bottom_navigation_bar.screens.HomePage
import com.example.todoapp.bottom_navigation_bar.screens.ProfileScreen
import com.example.todoapp.bottom_navigation_bar.screens.SettingsScreen


@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavScreens.Home.route
    ) {
        composable(BottomNavScreens.Home.route){
            HomePage()
        }
        composable(BottomNavScreens.Profile.route) {
            ProfileScreen()
        }
        composable(BottomNavScreens.Settings.route){
            SettingsScreen()
        }
    }
}