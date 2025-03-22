package com.example.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetUpNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = ScreenNav.Home.route
    ){
        composable(
            route = ScreenNav.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = ScreenNav.Detail.route
        ) {
            DetailedScreen(navCntrl = navController)
        }
    }
}