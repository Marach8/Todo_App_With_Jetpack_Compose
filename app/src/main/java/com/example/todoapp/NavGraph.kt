package com.example.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

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
            route = ScreenNav.Detail.route,
            arguments = listOf(
                navArgument(name = DETAIL_PARAM){
                    type = NavType.StringType
                },
                navArgument(name = NUMBER_PARAM){
                    type = NavType.IntType
                }
            )
        ) {
            val name = it.arguments?.getString(DETAIL_PARAM)
            val number = it.arguments?.getInt(NUMBER_PARAM).toString()
            DetailedScreen(navCntrl = navController, name = number ?: "")
        }
    }
}