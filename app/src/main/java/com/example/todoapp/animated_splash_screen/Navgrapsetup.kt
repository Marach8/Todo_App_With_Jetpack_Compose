package com.example.todoapp.animated_splash_screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraphSetup(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = AnScreens.SplashScreen.route
    ) {
        composable(route = AnScreens.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = AnScreens.MainScreen.route){
            MainScreen()
        }
    }
}